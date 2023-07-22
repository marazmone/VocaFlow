package di

import di.datasource.dataSourceModules
import di.repository.repositoryModules
import di.usecase.useCaseModules
import di.viewmodel.viewModelModules


fun appModules() = listOf(
    platformModule(),
    *dataSourceModules().toTypedArray(),
    *repositoryModules().toTypedArray(),
    *useCaseModules().toTypedArray(),
    *viewModelModules().toTypedArray(),
)
