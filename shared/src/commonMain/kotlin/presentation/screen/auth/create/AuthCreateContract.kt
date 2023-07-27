package presentation.screen.auth.create

import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState

class AuthCreateContract {

    data class State(
        val email: String = "",
        val password: String = "",
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val errorMessage: String = "",
        val buttonEnabled: Boolean = false,
        val showErrorPasswordDialog: Boolean = false,
    ) : BaseViewState

    sealed interface Action : BaseViewAction {

        data class Error(val errorMessage: String) : Action

        object Loading : Action

        data class UpdateEmail(val email: String) : Action

        data class UpdatePassword(val password: String) : Action

        data class PasswordError(val show: Boolean) : Action
    }

    sealed interface Effect : BaseViewEffect {

        object NavigateToMainFlow : Effect
    }
}
