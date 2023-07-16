package domain.firebase.auth

import cocoapods.FirebaseAuth.FIRAuth
import cocoapods.FirebaseAuth.FIRAuthDataResult
import cocoapods.FirebaseAuth.FIRAuthErrorCodeAccountExistsWithDifferentCredential
import cocoapods.FirebaseAuth.FIRAuthErrorCodeCredentialAlreadyInUse
import cocoapods.FirebaseAuth.FIRAuthErrorCodeEmailAlreadyInUse
import cocoapods.FirebaseAuth.FIRAuthErrorDomain
import domain.firebase.FirebaseException
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import kotlinx.coroutines.CompletableDeferred
import platform.Foundation.NSError

actual class FirebaseAuth internal constructor(private val auth: FIRAuth) {
    actual val currentUser: FirebaseUser?
        get() = auth.currentUser?.run { FirebaseUser(this) }

    actual suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        AuthResult(auth.awaitResult { createUserWithEmail(email, password, it) })

    actual suspend fun loginWithEmailAndPassword(email: String, password: String) =
        AuthResult(auth.awaitResult { signInWithEmail(email = email, password = password, completion = it) })

    actual suspend fun logout() {
        auth.throwError { signOut(it) }
    }
}

actual class AuthResult internal constructor(private val authResult: FIRAuthDataResult) {
    actual val user: FirebaseUser?
        get() = FirebaseUser(authResult.user)
}

actual open class FirebaseAuthException(message: String) : FirebaseException(message)

actual open class FirebaseAuthUserCollisionException(message: String) : FirebaseAuthException(message)

internal suspend inline fun <T, reified R> T.awaitResult(function: T.(callback: (R?, NSError?) -> Unit) -> Unit): R {
    val job = CompletableDeferred<R?>()
    function { result, error ->
        if (error == null) {
            job.complete(result)
        } else {
            job.completeExceptionally(error.toException())
        }
    }
    return job.await() as R
}

internal fun <T, R> T.throwError(block: T.(errorPointer: CPointer<ObjCObjectVar<NSError?>>) -> R): R {
    memScoped {
        val errorPointer: CPointer<ObjCObjectVar<NSError?>> = alloc<ObjCObjectVar<NSError?>>().ptr
        val result = block(errorPointer)
        val error: NSError? = errorPointer.pointed.value
        if (error != null) {
            throw error.toException()
        }
        return result
    }
}

private fun NSError.toException() = when (domain) {
    FIRAuthErrorDomain -> when (code) {
        FIRAuthErrorCodeEmailAlreadyInUse,
        FIRAuthErrorCodeAccountExistsWithDifferentCredential,
        FIRAuthErrorCodeCredentialAlreadyInUse -> FirebaseAuthUserCollisionException(localizedDescription)

        else -> FirebaseAuthException(localizedDescription)
    }

    else -> FirebaseException(localizedDescription)
}
