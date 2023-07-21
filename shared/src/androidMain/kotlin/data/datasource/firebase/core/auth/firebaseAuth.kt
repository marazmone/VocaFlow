package data.datasource.firebase.core.auth

import com.google.firebase.auth.ActionCodeSettings as MainActionCodeSettings
import com.google.firebase.auth.FirebaseAuth as MainFirebaseAuth
import data.model.firebase.auth.FirebaseActionCodeSettings
import data.model.firebase.auth.FirebaseAuthResultData
import data.model.firebase.auth.FirebaseAuthUserData
import kotlinx.coroutines.tasks.await

actual class FirebaseAuth internal constructor(private val auth: MainFirebaseAuth) {
    actual val currentUser: FirebaseAuthUserData?
        get() = auth.currentUser?.run { FirebaseAuthUserData(this) }

    actual suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        FirebaseAuthResultData(auth.createUserWithEmailAndPassword(email, password).await())

    actual suspend fun loginWithEmailAndPassword(email: String, password: String) =
        FirebaseAuthResultData(auth.signInWithEmailAndPassword(email, password).await())

    actual suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: FirebaseActionCodeSettings?) {
        auth.sendPasswordResetEmail(email, actionCodeSettings?.toAndroid()).await()
    }

    actual suspend fun logout() {
        auth.signOut()
    }
}

actual typealias FirebaseAuthException = com.google.firebase.auth.FirebaseAuthException

actual typealias FirebaseAuthUserCollisionException = com.google.firebase.auth.FirebaseAuthUserCollisionException

internal fun FirebaseActionCodeSettings.toAndroid() = MainActionCodeSettings.newBuilder()
    .setUrl(url)
    .also { androidPackageName?.run { it.setAndroidPackageName(packageName, installIfNotAvailable, minimumVersion) } }
    .also { dynamicLinkDomain?.run { it.setDynamicLinkDomain(this) } }
    .setHandleCodeInApp(canHandleCodeInApp)
    .also { iOSBundleId?.run { it.setIOSBundleId(this) } }
    .build()
