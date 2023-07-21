package di.viewmodelstate.test

import org.koin.dsl.module
import presentation.test.auth.FirebaseTestViewModel

fun testViewModelStateModule() = module {
    single { FirebaseTestViewModel(get(), get(), get(), get(), get()) }
}
