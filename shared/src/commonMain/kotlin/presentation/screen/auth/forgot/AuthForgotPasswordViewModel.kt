package presentation.screen.auth.forgot

import domain.usecase.firebase.auth.FirebaseAuthResetPasswordByEmailUseCase
import presentation.base.BaseViewModel
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Action
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Effect
import presentation.screen.auth.forgot.AuthForgotPasswordContract.State

class AuthForgotPasswordViewModel(
    private val authResetPasswordByEmailUseCase: FirebaseAuthResetPasswordByEmailUseCase,
) : BaseViewModel<State, Action, Effect>() {

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = when (action) {
        is Action.Loading -> currentState.copy(
            isLoading = true,
        )
    }

    fun updateEmail(mail: String) = Unit
}
