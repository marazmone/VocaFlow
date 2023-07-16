package domain.firebase.auth

import cocoapods.FirebaseAuth.FIRAuth

actual class FirebaseAuth internal constructor(private val auth: FIRAuth) {
    actual val currentUser: FirebaseUser?
        get() = auth.currentUser?.run { FirebaseUser(this) }
}