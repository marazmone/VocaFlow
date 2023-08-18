package presentation.screen.auth.forgot

import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState

class AuthForgotPasswordContract {

    data class State(
        val isLoading: Boolean = false,
        val email: String = "",
        val buttonEnabled: Boolean = false,
    ) : BaseViewState

    sealed interface Action : BaseViewAction {

        object Loading : Action
    }

    sealed interface Effect : BaseViewEffect
}
