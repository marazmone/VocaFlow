package di.datasource.firebase

import data.datasource.firebase.auth.FirebaseAuthDataSource
import data.datasource.firebase.auth.FirebaseAuthDataSourceImpl
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.auth
import org.koin.dsl.module

fun firebaseAuthDataSourceModule() = module {
    single<FirebaseAuthDataSource> { FirebaseAuthDataSourceImpl(Firebase.auth) }
}
