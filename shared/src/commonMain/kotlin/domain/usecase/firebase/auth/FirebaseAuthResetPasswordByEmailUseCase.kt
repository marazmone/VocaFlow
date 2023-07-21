package domain.usecase.firebase.auth

import data.model.firebase.auth.FirebaseActionCodeSettings
import domain.repository.FirebaseAuthRepository

class FirebaseAuthResetPasswordByEmailUseCase(
    private val repository: FirebaseAuthRepository,
) {

    suspend fun execute(email: String, actionCodeSettings: FirebaseActionCodeSettings? = null) {
        repository.sendPasswordResetEmail(email, actionCodeSettings)
    }
}
