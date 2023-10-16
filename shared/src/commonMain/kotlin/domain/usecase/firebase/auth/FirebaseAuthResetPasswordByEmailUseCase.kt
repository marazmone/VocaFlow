package domain.usecase.firebase.auth

import dev.gitlive.firebase.auth.ActionCodeSettings
import domain.repository.FirebaseAuthRepository

class FirebaseAuthResetPasswordByEmailUseCase(
    private val repository: FirebaseAuthRepository,
) {

    suspend fun execute(email: String, actionCodeSettings: ActionCodeSettings? = null) {
        repository.sendPasswordResetEmail(email, actionCodeSettings)
    }
}
