package data.datasource.firebase.core.auth

import cocoapods.FirebaseAuth.FIRAuthErrorCodeAccountExistsWithDifferentCredential
import cocoapods.FirebaseAuth.FIRAuthErrorCodeCredentialAlreadyInUse
import cocoapods.FirebaseAuth.FIRAuthErrorCodeEmailAlreadyInUse
import cocoapods.FirebaseAuth.FIRAuthErrorDomain
import data.datasource.firebase.core.FirebaseException
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.Foundation.NSError

actual open class FirebaseAuthException(message: String) : FirebaseException(message)

actual open class FirebaseAuthUserCollisionException(message: String) : FirebaseAuthException(message)

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

internal fun NSError.toException() = when (domain) {
    FIRAuthErrorDomain -> when (code) {
        FIRAuthErrorCodeEmailAlreadyInUse,
        FIRAuthErrorCodeAccountExistsWithDifferentCredential,
        FIRAuthErrorCodeCredentialAlreadyInUse -> FirebaseAuthUserCollisionException(
            localizedDescription
        )

        else -> FirebaseAuthException(localizedDescription)
    }

    else -> FirebaseException(localizedDescription)
}
