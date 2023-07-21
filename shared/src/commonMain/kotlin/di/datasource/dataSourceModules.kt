package di.datasource

import di.datasource.firebase.firebaseAuthDataSourceModule

fun dataSourceModules() = listOf(
    firebaseAuthDataSourceModule(),
)
