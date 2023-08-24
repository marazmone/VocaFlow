package data.datasource.firebase.core.auth

import data.datasource.firebase.core.Firebase
import data.model.firebase.auth.FirebaseActionCodeSettings
import data.model.firebase.auth.FirebaseAuthResultData
import data.model.firebase.auth.FirebaseAuthUserData

expect val Firebase.auth: FirebaseAuth

expect class FirebaseAuth {

    val currentUser: FirebaseAuthUserData?

    suspend fun createUserWithEmailAndPassword(email: String, password: String): FirebaseAuthResultData

    suspend fun loginWithEmailAndPassword(email: String, password: String): FirebaseAuthResultData

    suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: FirebaseActionCodeSettings? = null)

    suspend fun logout()

    fun useEmulator(host: String, port: Int)
}
