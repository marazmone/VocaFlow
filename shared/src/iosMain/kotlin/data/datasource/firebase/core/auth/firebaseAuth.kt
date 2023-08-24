package data.datasource.firebase.core.auth

import cocoapods.FirebaseAuth.FIRActionCodeSettings
import cocoapods.FirebaseAuth.FIRAuth
import data.datasource.firebase.core.Firebase
import data.datasource.firebase.core.await
import data.datasource.firebase.core.awaitResult
import data.model.firebase.auth.FirebaseActionCodeSettings
import data.model.firebase.auth.FirebaseAuthResultData
import data.model.firebase.auth.FirebaseAuthUserData
import platform.Foundation.NSURL

actual val Firebase.auth
    get() = FirebaseAuth(FIRAuth.auth())

actual class FirebaseAuth internal constructor(private val auth: FIRAuth) {
    actual val currentUser: FirebaseAuthUserData?
        get() = auth.currentUser?.run { FirebaseAuthUserData(this) }

    actual suspend fun createUserWithEmailAndPassword(email: String, password: String) =
        FirebaseAuthResultData(auth.awaitResult { createUserWithEmail(email, password, it) })

    actual suspend fun loginWithEmailAndPassword(email: String, password: String) =
        FirebaseAuthResultData(auth.awaitResult {
            signInWithEmail(
                email = email,
                password = password,
                completion = it
            )
        })

    actual suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: FirebaseActionCodeSettings?) {
        auth.await {
            actionCodeSettings?.let { actionSettings ->
                sendPasswordResetWithEmail(
                    email,
                    actionSettings.toIos(),
                    it
                )
            } ?: sendPasswordResetWithEmail(email = email, completion = it)
        }
    }

    actual suspend fun logout() {
        auth.throwError { signOut(it) }
    }

    actual fun useEmulator(host: String, port: Int) = auth.useEmulatorWithHost(host, port.toLong())
}

internal fun FirebaseActionCodeSettings.toIos() = FIRActionCodeSettings().also {
    it.URL = NSURL.URLWithString(url)
    androidPackageName?.run { it.setAndroidPackageName(packageName, installIfNotAvailable, minimumVersion) }
    it.dynamicLinkDomain = dynamicLinkDomain
    it.handleCodeInApp = canHandleCodeInApp
    iOSBundleId?.run { it.setIOSBundleID(this) }
}
