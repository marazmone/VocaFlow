package data.model.firebase.auth

import com.google.firebase.auth.FirebaseUser

actual class FirebaseAuthUserData internal constructor(private val user: FirebaseUser) {

    actual val uid: String
        get() = user.uid
}
