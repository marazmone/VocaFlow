package domain.firebase.auth

class FirebaseAuthProviderImpl(
    private val firebaseAuth: FirebaseAuth
) : FirebaseAuthProvider {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult =
        firebaseAuth.createUserWithEmailAndPassword(email, password)

    override suspend fun loginWithEmailAndPassword(email: String, password: String): AuthResult =
        firebaseAuth.loginWithEmailAndPassword(email, password)

    override suspend fun logout() {
        firebaseAuth.logout()
    }
}
