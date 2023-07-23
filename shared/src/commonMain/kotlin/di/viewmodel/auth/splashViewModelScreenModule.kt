package di.viewmodel.auth

import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.screen.splash.SplashViewModel

fun splashViewModelScreenModule(): Module = module {
    single { SplashViewModel(get()) }
}
