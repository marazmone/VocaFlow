package data.repository.firebase.auth

import data.datasource.firebase.auth.FirebaseAuthDataSource
import data.model.firebase.auth.FirebaseActionCodeSettings
import data.model.firebase.auth.toDomain
import domain.model.firebase.auth.FirebaseAuthResult
import domain.model.firebase.auth.FirebaseAuthUser
import domain.repository.FirebaseAuthRepository

class FirebaseAuthRepositoryImpl(
    private val firebaseAuthDataSource: FirebaseAuthDataSource,
) : FirebaseAuthRepository {

    override val currentUser: FirebaseAuthUser? get() = firebaseAuthDataSource.currentUser?.toDomain()

    override suspend fun createUserWithEmailAndPassword(email: String, password: String): FirebaseAuthResult {
        return firebaseAuthDataSource.createUserWithEmailAndPassword(email, password).toDomain()
    }

    override suspend fun loginWithEmailAndPassword(email: String, password: String): FirebaseAuthResult {
        return firebaseAuthDataSource.loginWithEmailAndPassword(email, password).toDomain()
    }

    override suspend fun sendPasswordResetEmail(email: String, actionCodeSettings: FirebaseActionCodeSettings?) {
        firebaseAuthDataSource.sendPasswordResetEmail(email)
    }

    override suspend fun logout() {
        firebaseAuthDataSource.logout()
    }
}
