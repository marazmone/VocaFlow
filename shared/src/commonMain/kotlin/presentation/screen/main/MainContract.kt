package presentation.screen.main

import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState

class MainContract {

    data class State(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val errorMessage: String = "",
    ) : BaseViewState

    sealed interface Action : BaseViewAction {

        object IDLE : Action

        data class Error(val errorMessage: String) : Action

        object Loading : Action
    }

    sealed interface Effect : BaseViewEffect {

        object NavigateLogout : Effect
    }
}
