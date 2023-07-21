package domain.usecase.firebase.auth

import domain.model.firebase.auth.FirebaseAuthUser
import domain.repository.FirebaseAuthRepository

class FirebaseAuthGetCurrentUserUseCase(
    private val repository: FirebaseAuthRepository,
) {

    fun execute(): FirebaseAuthUser? = repository.currentUser
}
