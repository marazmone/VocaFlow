package di.repository.firebase

import data.repository.firebase.auth.FirebaseAuthRepositoryImpl
import domain.repository.FirebaseAuthRepository
import org.koin.dsl.module

fun firebaseAuthRepositoryModule() = module {
    single<FirebaseAuthRepository> { FirebaseAuthRepositoryImpl(get()) }
}
