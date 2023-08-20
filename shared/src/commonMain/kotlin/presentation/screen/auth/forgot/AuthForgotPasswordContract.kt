package presentation.screen.auth.forgot

import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState
import presentation.screen.auth.login.AuthLoginContract.Action

class AuthForgotPasswordContract {

    data class State(
        val isLoading: Boolean = false,
        val email: String = "",
        val buttonEnabled: Boolean = false,
        val isError: Boolean = false,
        val errorMessage: String = "",
        val isSuccess: Boolean = false,
    ) : BaseViewState

    sealed interface Action : BaseViewAction {

        object IDLE : Action

        object Loading : Action

        data class Error(val errorMessage: String) : Action

        data class UpdateEmail(val email: String) : Action

        object Success : Action
    }

    sealed interface Effect : BaseViewEffect {

        object NavigatePopBack : Effect
    }
}
