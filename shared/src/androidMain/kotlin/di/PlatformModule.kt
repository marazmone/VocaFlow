package di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import data.datasource.firebase.core.auth.FirebaseAuth
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { FirebaseAuth(Firebase.auth) }
}
