package presentation.screen.auth.login

import dev.gitlive.firebase.auth.FirebaseAuthInvalidUserException
import domain.usecase.firebase.auth.FirebaseAuthLoginWithEmailUseCase
import domain.util.errorOrDefault
import domain.util.isEmailValid
import domain.util.onFailureWithLog
import kotlinx.coroutines.launch
import presentation.base.BaseViewModel
import presentation.screen.auth.login.AuthLoginContract.Action
import presentation.screen.auth.login.AuthLoginContract.Effect
import presentation.screen.auth.login.AuthLoginContract.State
import presentation.text.Strings

class AuthLoginViewModel(
    private val loginWithEmailUseCase: FirebaseAuthLoginWithEmailUseCase,
) : BaseViewModel<State, Action, Effect>() {

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = when (action) {
        is Action.IDLE -> currentState.copy(
            email = "",
            password = "",
            isLoading = false,
            isError = false,
            errorMessage = "",
            buttonEnabled = false,
        )

        is Action.Error -> currentState.copy(
            errorMessage = action.errorMessage,
            isError = true,
            isLoading = false,
        )

        is Action.Loading -> currentState.copy(
            isLoading = true,
            isError = false,
        )

        is Action.UpdateEmail -> currentState.copy(
            email = action.email,
            isError = false,
            isLoading = false,
            buttonEnabled = action.email.isEmailValid
                .and(action.email.isNotEmpty())
                .and(state.value.password.isNotEmpty()),
        )

        is Action.UpdatePassword -> currentState.copy(
            password = action.password,
            isError = false,
            isLoading = false,
            buttonEnabled = state.value.email.isEmailValid
                .and(state.value.email.isNotEmpty())
                .and(state.value.password.isNotEmpty()),
        )
    }

    fun updateEmail(email: String) {
        sendAction { Action.UpdateEmail(email) }
    }

    fun updatePassword(password: String) {
        sendAction { Action.UpdatePassword(password) }
    }

    fun resetState() {
        sendAction { Action.IDLE }
    }

    fun login() {
        launch {
            sendAction { Action.Loading }
            runCatching {
                loginWithEmailUseCase.execute(state.value.email, state.value.password)
            }.onFailureWithLog {
                if (it is FirebaseAuthInvalidUserException) {
                    sendAction { Action.Error(Strings.get("account_not_found")) }
                } else {
                    sendAction { Action.Error(it.message.errorOrDefault()) }
                }
            }.onSuccess {
                sendAction { Action.IDLE }
                sendEffect { Effect.NavigateToMainFlow }
            }
        }
    }
}
