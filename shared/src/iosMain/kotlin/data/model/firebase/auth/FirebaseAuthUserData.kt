package data.model.firebase.auth

import cocoapods.FirebaseAuth.FIRUser

actual class FirebaseAuthUserData internal constructor(private val user: FIRUser) {

    actual val uid: String
        get() = user.uid
}
