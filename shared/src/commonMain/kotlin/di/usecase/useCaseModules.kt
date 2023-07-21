package di.usecase

import di.usecase.firebase.firebaseAuthUseCaseModule

fun useCaseModules() = listOf(
    firebaseAuthUseCaseModule(),
)
