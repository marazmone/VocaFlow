package di.datasource.firebase

import data.datasource.firebase.auth.FirebaseAuthDataSource
import data.datasource.firebase.auth.FirebaseAuthDataSourceImpl
import org.koin.dsl.module

fun firebaseAuthDataSourceModule() = module {
    single<FirebaseAuthDataSource> { FirebaseAuthDataSourceImpl(get()) }
}
