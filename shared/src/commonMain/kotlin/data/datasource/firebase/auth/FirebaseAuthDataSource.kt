package data.datasource.firebase.auth

import dev.gitlive.firebase.auth.ActionCodeSettings
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseUser

interface FirebaseAuthDataSource {

    val currentUser: FirebaseUser?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun loginWithEmailAndPassword(email: String, password: String): AuthResult

    suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: ActionCodeSettings? = null)

    suspend fun logout()
}
