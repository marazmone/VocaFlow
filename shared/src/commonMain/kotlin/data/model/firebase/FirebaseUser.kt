package data.model.firebase

import dev.gitlive.firebase.auth.FirebaseUser
import domain.model.firebase.auth.FirebaseAuthUser

fun FirebaseUser?.toDomain(): FirebaseAuthUser? = this?.run {
    FirebaseAuthUser(
        uid = uid,
    )
}