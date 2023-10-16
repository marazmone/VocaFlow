package domain.repository

import dev.gitlive.firebase.auth.ActionCodeSettings
import domain.model.firebase.auth.FirebaseAuthResult
import domain.model.firebase.auth.FirebaseAuthUser

interface FirebaseAuthRepository {

    val currentUser: FirebaseAuthUser?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): FirebaseAuthResult

    suspend fun loginWithEmailAndPassword(email: String, password: String): FirebaseAuthResult

    suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: ActionCodeSettings? = null)

    suspend fun logout()
}
