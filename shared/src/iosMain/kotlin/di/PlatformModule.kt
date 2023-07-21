package di

import cocoapods.FirebaseAuth.FIRAuth
import data.datasource.firebase.core.auth.FirebaseAuth
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { FirebaseAuth(FIRAuth.auth()) }
}
