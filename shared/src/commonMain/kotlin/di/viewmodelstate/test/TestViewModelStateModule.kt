package di.viewmodelstate.test

import org.koin.dsl.module
import presentation.test.auth.FirebaseTestScreenStateModel

fun testViewModelStateModule() = module {
    single { FirebaseTestScreenStateModel(get(), get(), get(), get()) }
}
