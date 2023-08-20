package presentation.screen.auth.forgot

import data.datasource.firebase.core.auth.FirebaseAuthInvalidUserException
import domain.usecase.firebase.auth.FirebaseAuthResetPasswordByEmailUseCase
import domain.util.errorOrDefault
import domain.util.isEmailValid
import domain.util.onFailureWithLog
import kotlinx.coroutines.launch
import presentation.base.BaseViewModel
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Action
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Action.Error
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Action.IDLE
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Action.Loading
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Action.Success
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Action.UpdateEmail
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Effect
import presentation.screen.auth.forgot.AuthForgotPasswordContract.Effect.NavigatePopBack
import presentation.screen.auth.forgot.AuthForgotPasswordContract.State
import presentation.text.Strings

class AuthForgotPasswordViewModel(
    private val authResetPasswordByEmailUseCase: FirebaseAuthResetPasswordByEmailUseCase,
) : BaseViewModel<State, Action, Effect>() {

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State {
        return when (action) {
            is Loading -> currentState.copy(
                isLoading = true,
                isError = false,
                isSuccess = false,
            )

            is Error -> currentState.copy(
                isLoading = false,
                isError = true,
                errorMessage = action.errorMessage,
                isSuccess = false,
            )

            is UpdateEmail -> currentState.copy(
                email = action.email,
                buttonEnabled = action.email.isEmailValid && action.email.isNotEmpty(),
                isSuccess = false,
                isError = false,
                isLoading = false,
            )

            is IDLE -> currentState.copy(
                isLoading = false,
                isError = false,
                email = "",
                isSuccess = false,
                buttonEnabled = false,
            )

            is Success -> currentState.copy(
                isLoading = false,
                isError = false,
                email = "",
                isSuccess = true,
            )
        }
    }

    fun updateEmail(mail: String) {
        sendAction { UpdateEmail(mail) }
    }

    fun resetPassword() {
        launch {
            sendAction { Loading }
            runCatching {
                authResetPasswordByEmailUseCase.execute(state.value.email)
            }.onFailureWithLog {
                if (it is FirebaseAuthInvalidUserException) {
                    sendAction { Error(Strings.get("account_not_found")) }
                } else {
                    sendAction { Error(it.message.errorOrDefault()) }
                }
            }.onSuccess {
                sendAction { Success }
            }
        }
    }

    fun popBack() {
        resetState()
        sendEffect { NavigatePopBack }
    }

    fun resetState() {
        sendAction { IDLE }
    }
}
