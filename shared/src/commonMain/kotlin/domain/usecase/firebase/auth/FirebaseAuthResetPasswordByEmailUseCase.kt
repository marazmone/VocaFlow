package domain.usecase.firebase.auth

import domain.firebase.auth.ActionCodeSettings
import domain.firebase.auth.FirebaseAuthProvider

class FirebaseAuthResetPasswordByEmailUseCase(
    private val firebaseAuthProvider: FirebaseAuthProvider,
) {

    suspend fun execute(email: String, actionCodeSettings: ActionCodeSettings? = null) {
        firebaseAuthProvider.sendPasswordResetEmail(email, actionCodeSettings)
    }
}
