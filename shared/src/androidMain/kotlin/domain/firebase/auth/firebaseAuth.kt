package domain.firebase.auth

import com.google.firebase.auth.FirebaseAuth as MainFirebaseAuth

actual class FirebaseAuth internal constructor(private val auth: MainFirebaseAuth) {
    actual val currentUser: FirebaseUser?
        get() = auth.currentUser?.run { FirebaseUser(this) }
}