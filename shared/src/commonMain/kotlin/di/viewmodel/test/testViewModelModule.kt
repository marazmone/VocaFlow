package di.viewmodel.test

import org.koin.dsl.module
import presentation.test.auth.FirebaseTestViewModel

fun testViewModelModule() = module {
    single { FirebaseTestViewModel(get(), get(), get(), get(), get()) }
}
