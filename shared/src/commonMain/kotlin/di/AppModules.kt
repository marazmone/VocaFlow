package di

import di.firebase.firebaseCoreModule
import di.usecase.firebaseUseCaseModule
import di.viewmodelstate.test.testViewModelStateModule

fun appModules() = listOf(
    platformModule(),
    firebaseCoreModule(),
    firebaseUseCaseModule(),
    testViewModelStateModule(),
)
