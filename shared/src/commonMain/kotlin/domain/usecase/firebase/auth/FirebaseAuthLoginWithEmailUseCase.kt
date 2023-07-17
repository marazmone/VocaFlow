package domain.usecase.firebase.auth

import domain.firebase.auth.AuthResult
import domain.firebase.auth.FirebaseAuthProvider

class FirebaseAuthLoginWithEmailUseCase(
    private val firebaseAuthProvider: FirebaseAuthProvider,
) {

    suspend fun execute(email: String, password: String): AuthResult {
        return firebaseAuthProvider.loginWithEmailAndPassword(email, password)
    }
}
