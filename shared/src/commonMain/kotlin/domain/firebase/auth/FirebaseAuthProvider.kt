package domain.firebase.auth

interface FirebaseAuthProvider {

    val currentUser: FirebaseUser?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun loginWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun logout()
}
