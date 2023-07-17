package domain.firebase.auth

import domain.firebase.FirebaseException

expect class FirebaseAuth {

    val currentUser: FirebaseUser?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun loginWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: ActionCodeSettings? = null)

    suspend fun logout()
}

expect class AuthResult {
    val user: FirebaseUser?
}

data class ActionCodeSettings(
    val url: String,
    val androidPackageName: AndroidPackageName? = null,
    val dynamicLinkDomain: String? = null,
    val canHandleCodeInApp: Boolean = false,
    val iOSBundleId: String? = null
)

data class AndroidPackageName(
    val packageName: String,
    val installIfNotAvailable: Boolean = true,
    val minimumVersion: String? = null
)

expect open class FirebaseAuthException : FirebaseException

expect class FirebaseAuthUserCollisionException : FirebaseAuthException
