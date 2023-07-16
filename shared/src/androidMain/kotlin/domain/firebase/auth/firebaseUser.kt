package domain.firebase.auth

import com.google.firebase.auth.FirebaseUser as MainFirebaseAuth

actual class FirebaseUser internal constructor(private val user: MainFirebaseAuth) {

    actual val uid: String
        get() = user.uid
}