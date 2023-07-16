package domain.usecase.firebase.auth

import domain.firebase.auth.FirebaseAuthProvider
import domain.firebase.auth.FirebaseUser

class FirebaseAuthGetCurrentUserUseCase(
    private val firebaseAuthProvider: FirebaseAuthProvider,
) {

    fun execute(): FirebaseUser? = firebaseAuthProvider.currentUser
}
