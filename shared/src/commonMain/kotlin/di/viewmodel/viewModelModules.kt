package di.viewmodel

import di.viewmodel.auth.authViewModelModule
import di.viewmodel.auth.splashViewModelScreenModule
import di.viewmodel.main.mainViewModelModule
import di.viewmodel.test.testViewModelModule

fun viewModelModules() = listOf(
    testViewModelModule(),
    splashViewModelScreenModule(),
    authViewModelModule(),
    mainViewModelModule(),
)
