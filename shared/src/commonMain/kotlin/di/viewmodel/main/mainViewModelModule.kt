package di.viewmodel.main

import org.koin.core.module.Module
import org.koin.dsl.module
import presentation.screen.main.MainViewModel

fun mainViewModelModule(): Module = module {
    single { MainViewModel(get()) }
}
