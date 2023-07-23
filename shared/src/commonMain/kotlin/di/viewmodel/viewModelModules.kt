package di.viewmodel

import di.viewmodel.auth.splashViewModelScreenModule
import di.viewmodel.test.testViewModelModule

fun viewModelModules() = listOf(
    testViewModelModule(),
    splashViewModelScreenModule(),
)
