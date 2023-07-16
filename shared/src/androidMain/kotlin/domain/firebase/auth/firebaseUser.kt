package domain.firebase.auth

import com.google.firebase.auth.FirebaseUser as MainFirebaseUser

actual class FirebaseUser internal constructor(private val user: MainFirebaseUser) {

    actual val uid: String
        get() = user.uid
}
