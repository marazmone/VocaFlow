package domain.firebase.auth

import com.google.firebase.auth.ActionCodeSettings as MainActionCodeSettings
import com.google.firebase.auth.AuthResult as MainAuthResult
import com.google.firebase.auth.FirebaseAuth as MainFirebaseAuth
import kotlinx.coroutines.tasks.await

actual class FirebaseAuth internal constructor(private val auth: MainFirebaseAuth) {
    actual val currentUser: FirebaseUser?
        get() = auth.currentUser?.run { FirebaseUser(this) }

    actual suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        AuthResult(auth.createUserWithEmailAndPassword(email, password).await())

    actual suspend fun loginWithEmailAndPassword(email: String, password: String) =
        AuthResult(auth.signInWithEmailAndPassword(email, password).await())

    actual suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: ActionCodeSettings?) {
        auth.sendPasswordResetEmail(email, actionCodeSettings?.toAndroid()).await()
    }

    actual suspend fun logout() {
        auth.signOut()
    }
}

actual class AuthResult internal constructor(private val authResult: MainAuthResult) {
    actual val user: FirebaseUser?
        get() = authResult.user?.let { FirebaseUser(it) }
}

actual typealias FirebaseAuthException = com.google.firebase.auth.FirebaseAuthException

actual typealias FirebaseAuthUserCollisionException = com.google.firebase.auth.FirebaseAuthUserCollisionException

internal fun ActionCodeSettings.toAndroid() = MainActionCodeSettings.newBuilder()
    .setUrl(url)
    .also { androidPackageName?.run { it.setAndroidPackageName(packageName, installIfNotAvailable, minimumVersion) } }
    .also { dynamicLinkDomain?.run { it.setDynamicLinkDomain(this) } }
    .setHandleCodeInApp(canHandleCodeInApp)
    .also { iOSBundleId?.run { it.setIOSBundleId(this) } }
    .build()
