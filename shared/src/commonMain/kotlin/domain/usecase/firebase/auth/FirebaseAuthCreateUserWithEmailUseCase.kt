package domain.usecase.firebase.auth

import domain.model.firebase.auth.FirebaseAuthResult
import domain.repository.FirebaseAuthRepository

class FirebaseAuthCreateUserWithEmailUseCase(
    private val repository: FirebaseAuthRepository,
) {

    suspend fun execute(email: String, password: String): FirebaseAuthResult {
        return repository.createUserWithEmailAndPassword(email, password)
    }
}
