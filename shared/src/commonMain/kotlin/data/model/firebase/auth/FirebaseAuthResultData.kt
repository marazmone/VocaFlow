package data.model.firebase.auth

import domain.model.firebase.auth.FirebaseAuthResult

expect class FirebaseAuthResultData {
    val user: FirebaseAuthUserData?
}

fun FirebaseAuthResultData.toDomain(): FirebaseAuthResult = FirebaseAuthResult(
    user = this.user.toDomain(),
)
