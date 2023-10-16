package data.model.firebase

import dev.gitlive.firebase.auth.AuthResult
import domain.model.firebase.auth.FirebaseAuthResult

fun AuthResult.toDomain(): FirebaseAuthResult = FirebaseAuthResult(
    user = user.toDomain(),
)