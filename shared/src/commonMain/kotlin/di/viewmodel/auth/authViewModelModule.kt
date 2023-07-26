package di.viewmodel.auth

import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.screen.auth.create.AuthCreateViewModel

fun authViewModelModule(): Module = module {
    single { AuthCreateViewModel(get(), get()) }
}
