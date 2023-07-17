package di.firebase

import domain.firebase.auth.FirebaseAuthProvider
import domain.firebase.auth.FirebaseAuthProviderImpl
import org.koin.dsl.module

fun firebaseCoreModule() = module {
    single<FirebaseAuthProvider> { FirebaseAuthProviderImpl(get()) }
}
