package domain.usecase.firebase.auth

import domain.firebase.auth.FirebaseAuthProvider

class FirebaseAuthLogoutUseCase(
    private val firebaseAuthProvider: FirebaseAuthProvider,
) {

    suspend fun execute() = firebaseAuthProvider.logout()
}
