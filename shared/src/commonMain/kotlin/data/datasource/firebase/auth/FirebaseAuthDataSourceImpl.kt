package data.datasource.firebase.auth

import dev.gitlive.firebase.auth.ActionCodeSettings
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.FirebaseUser

class FirebaseAuthDataSourceImpl(
    private val firebaseAuth: FirebaseAuth,
) : FirebaseAuthDataSource {

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult =
        firebaseAuth.createUserWithEmailAndPassword(email, password)

    override suspend fun loginWithEmailAndPassword(email: String, password: String): AuthResult =
        firebaseAuth.signInWithEmailAndPassword(email, password)

    override suspend fun sendPasswordResetEmail(
        email: String,
        actionCodeSettings: ActionCodeSettings?
    ) {
        firebaseAuth.sendPasswordResetEmail(email, actionCodeSettings)
    }

    override suspend fun logout() {
        firebaseAuth.signOut()
    }
}
