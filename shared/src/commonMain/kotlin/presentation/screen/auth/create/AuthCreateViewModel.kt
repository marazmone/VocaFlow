package presentation.screen.auth.create

import dev.gitlive.firebase.auth.FirebaseAuthUserCollisionException
import domain.usecase.firebase.auth.FirebaseAuthCreateUserWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthLoginWithEmailUseCase
import domain.util.errorOrDefault
import domain.util.isEmailValid
import domain.util.isStrongPassword
import domain.util.onFailureWithLog
import kotlinx.coroutines.launch
import presentation.base.BaseViewModel
import presentation.screen.auth.create.AuthCreateContract.Action
import presentation.screen.auth.create.AuthCreateContract.Effect
import presentation.screen.auth.create.AuthCreateContract.State
import presentation.text.Strings

class AuthCreateViewModel(
    private val createUserWithEmailUseCase: FirebaseAuthCreateUserWithEmailUseCase,
    private val loginWithEmailUseCase: FirebaseAuthLoginWithEmailUseCase,
) : BaseViewModel<State, Action, Effect>() {

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = when (action) {
        is Action.IDLE -> currentState.copy(
            isLoading = false,
            isError = false,
            errorMessage = "",
            email = "",
            password = "",
        )

        is Action.Error -> currentState.copy(
            isLoading = false,
            isError = true,
            errorMessage = action.errorMessage,
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

    fun tryCreateAccount() {
        sendAction { Action.Loading }
        if (currentState.password.isStrongPassword) {
            createOrLogin()
        } else {
            sendAction { Action.Error(Strings.get("auth_create_password_error")) }
        }
    }

    fun resetState() {
        sendAction { Action.IDLE }
    }

    private fun createOrLogin() {
        launch {
            sendAction { Action.Loading }
            runCatching {
                createUserWithEmailUseCase.execute(state.value.email, state.value.password)
            }.onFailureWithLog {
                if (it is FirebaseAuthUserCollisionException) {
                    login()
                } else {
                    sendAction { Action.Error(it.message.errorOrDefault()) }
                }
            }.onSuccess {
                sendAction { Action.IDLE }
                sendEffect { Effect.NavigateToMainFlow }
            }
        }
    }

    private fun login() {
        launch {
            sendAction { Action.Loading }
            runCatching {
                loginWithEmailUseCase.execute(state.value.email, state.value.password)
            }.onFailureWithLog {
                sendAction { Action.Error(it.message.errorOrDefault()) }
            }.onSuccess {
                sendAction { Action.IDLE }
                sendEffect { Effect.NavigateToMainFlow }
            }
        }
    }
}
