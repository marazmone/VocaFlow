package presentation.screen.splash

import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState

class SplashScreenContract {

    data class State(
        val isError: Boolean = false,
        val errorMessage: String = "",
    ) : BaseViewState

    sealed interface Action : BaseViewAction {

        data class Error(val message: String) : Action
    }

    sealed interface Effect : BaseViewEffect {

        data object NavigateToAuthFlow : Effect

        data object NavigateToMainFlow : Effect
    }
}
