package data.model.firebase.auth

import cocoapods.FirebaseAuth.FIRAuthDataResult

actual class FirebaseAuthResultData internal constructor(private val authResult: FIRAuthDataResult) {
    actual val user: FirebaseAuthUserData?
        get() = FirebaseAuthUserData(authResult.user)
}
