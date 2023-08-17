package di.viewmodel.auth

import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.screen.auth.create.AuthCreateViewModel
import presentation.screen.auth.login.AuthLoginViewModel

fun authViewModelModule(): Module = module {
    single { AuthCreateViewModel(get(), get()) }
    single { AuthLoginViewModel(get()) }
}
