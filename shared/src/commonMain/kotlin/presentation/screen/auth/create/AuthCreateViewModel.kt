package presentation.screen.auth.create

import domain.usecase.firebase.auth.FirebaseAuthCreateUserWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthLoginWithEmailUseCase
import domain.util.isEmailValid
import domain.util.isStrongPassword
import presentation.base.BaseViewModel
import presentation.screen.auth.create.AuthCreateContract.Action
import presentation.screen.auth.create.AuthCreateContract.Effect
import presentation.screen.auth.create.AuthCreateContract.State

class AuthCreateViewModel(
    private val createUserWithEmailUseCase: FirebaseAuthCreateUserWithEmailUseCase,
    private val loginWithEmailUseCase: FirebaseAuthLoginWithEmailUseCase,
) : BaseViewModel<State, Action, Effect>() {

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = when (action) {
        is Action.Error -> currentState.copy(
            isLoading = false,
            isError = true,
            errorMessage = action.errorMessage,
            showErrorPasswordDialog = false,
        )

        is Action.Loading -> currentState.copy(
            isLoading = true,
            isError = false,
            showErrorPasswordDialog = false,
        )

        is Action.UpdateEmail -> currentState.copy(
            email = action.email,
            isError = false,
            isLoading = false,
            buttonEnabled = action.email.isEmailValid && action.email.isNotEmpty(),
            showErrorPasswordDialog = false,
        )

        is Action.UpdatePassword -> currentState.copy(
            password = action.password,
            isError = false,
            isLoading = false,
            showErrorPasswordDialog = false,
        )

        is Action.PasswordError -> currentState.copy(
            showErrorPasswordDialog = action.show,
            isLoading = false,
            isError = false,
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
            createUser()
        } else {
            sendAction { Action.PasswordError(true) }
        }
    }

    private fun createUser() {
        // TODO: Implement this method with Firebase Auth
    }

    fun closeErrorPasswordDialog() {
        sendAction { Action.PasswordError(false) }
    }
}
