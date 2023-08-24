package data.model.firebase.auth

import cocoapods.FirebaseAuth.FIRUser
import data.datasource.firebase.core.await

actual class FirebaseAuthUserData internal constructor(private val user: FIRUser) {

    actual val uid: String
        get() = user.uid

    actual suspend fun delete() = user.await { deleteWithCompletion(it) }.run { Unit }
}
