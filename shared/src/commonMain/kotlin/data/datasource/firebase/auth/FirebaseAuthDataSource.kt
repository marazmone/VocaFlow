package data.datasource.firebase.auth

import data.model.firebase.auth.FirebaseActionCodeSettings
import data.model.firebase.auth.FirebaseAuthResultData
import data.model.firebase.auth.FirebaseAuthUserData

interface FirebaseAuthDataSource {

    val currentUser: FirebaseAuthUserData?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): FirebaseAuthResultData

    suspend fun loginWithEmailAndPassword(email: String, password: String): FirebaseAuthResultData

    suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: FirebaseActionCodeSettings? = null)

    suspend fun logout()
}