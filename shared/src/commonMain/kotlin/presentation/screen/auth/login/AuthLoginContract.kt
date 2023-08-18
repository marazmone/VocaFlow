package presentation.screen.auth.login

import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState

class AuthLoginContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val errorMessage: String = "",
        val buttonEnabled: Boolean = false,
    ) : BaseViewState

    sealed interface Action : BaseViewAction {

        object IDLE : Action

        data class Error(val errorMessage: String) : Action

        object Loading : Action

        data class UpdateEmail(val email: String) : Action

        data class UpdatePassword(val password: String) : Action
    }

    sealed interface Effect : BaseViewEffect {

        object NavigateToMainFlow : Effect
    }
}
