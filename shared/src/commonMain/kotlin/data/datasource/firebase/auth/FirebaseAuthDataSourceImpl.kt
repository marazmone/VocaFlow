package data.datasource.firebase.auth

import data.datasource.firebase.core.auth.FirebaseAuth
import data.model.firebase.auth.FirebaseActionCodeSettings
import data.model.firebase.auth.FirebaseAuthResultData
import data.model.firebase.auth.FirebaseAuthUserData

class FirebaseAuthDataSourceImpl(
    private val firebaseAuth: FirebaseAuth,
) : FirebaseAuthDataSource {

    override val currentUser: FirebaseAuthUserData?
        get() = firebaseAuth.currentUser

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): FirebaseAuthResultData =
        firebaseAuth.createUserWithEmailAndPassword(email, password)

    override suspend fun loginWithEmailAndPassword(email: String, password: String): FirebaseAuthResultData =
        firebaseAuth.loginWithEmailAndPassword(email, password)

    override suspend fun sendPasswordResetEmail(
        email: String,
        actionCodeSettings: FirebaseActionCodeSettings?
    ) {
        firebaseAuth.sendPasswordResetEmail(email, actionCodeSettings)
    }

    override suspend fun logout() {
        firebaseAuth.logout()
    }
}
