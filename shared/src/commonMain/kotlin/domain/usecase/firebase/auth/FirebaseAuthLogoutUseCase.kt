package domain.usecase.firebase.auth

import domain.repository.FirebaseAuthRepository

class FirebaseAuthLogoutUseCase(
    private val repository: FirebaseAuthRepository,
) {

    suspend fun execute() = repository.logout()
}
