package domain.repository

import data.model.firebase.auth.FirebaseActionCodeSettings
import domain.model.firebase.auth.FirebaseAuthResult
import domain.model.firebase.auth.FirebaseAuthUser

interface FirebaseAuthRepository {

    val currentUser: FirebaseAuthUser?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): FirebaseAuthResult

    suspend fun loginWithEmailAndPassword(email: String, password: String): FirebaseAuthResult

    suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: FirebaseActionCodeSettings? = null)

    suspend fun logout()
}
