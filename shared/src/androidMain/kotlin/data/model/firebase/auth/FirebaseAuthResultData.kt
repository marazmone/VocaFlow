package data.model.firebase.auth

import com.google.firebase.auth.AuthResult

actual class FirebaseAuthResultData internal constructor(private val authResult: AuthResult) {
    actual val user: FirebaseAuthUserData?
        get() = authResult.user?.let { FirebaseAuthUserData(it) }
}
