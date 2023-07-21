package di.repository

import di.repository.firebase.firebaseAuthRepositoryModule

fun repositoryModules() = listOf(
    firebaseAuthRepositoryModule(),
)
