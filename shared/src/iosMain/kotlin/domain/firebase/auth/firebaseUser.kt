package domain.firebase.auth

import cocoapods.FirebaseAuth.FIRUser

actual class FirebaseUser internal constructor(private val user: FIRUser) {

    actual val uid: String
        get() = user.uid
}
