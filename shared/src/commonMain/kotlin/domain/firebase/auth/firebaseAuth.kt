package domain.firebase.auth

import domain.firebase.FirebaseException

expect class FirebaseAuth {

    val currentUser: FirebaseUser?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun loginWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun logout()
}

expect class AuthResult {
    val user: FirebaseUser?
}

expect open class FirebaseAuthException : FirebaseException

expect class FirebaseAuthUserCollisionException : FirebaseAuthException
