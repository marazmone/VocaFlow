package data.model.firebase.auth

import domain.model.firebase.auth.FirebaseAuthUser

expect class FirebaseAuthUserData {
    val uid: String

    suspend fun delete()
}

fun FirebaseAuthUserData?.toDomain(): FirebaseAuthUser = FirebaseAuthUser(
    uid = this?.uid.orEmpty()
)
