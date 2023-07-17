package presentation.test.auth

import domain.firebase.auth.FirebaseAuthUserCollisionException
import domain.usecase.firebase.auth.FirebaseAuthCreateUserWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthGetCurrentUserUseCase
import domain.usecase.firebase.auth.FirebaseAuthLoginWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthLogoutUseCase
import domain.usecase.firebase.auth.FirebaseAuthResetPasswordByEmailUseCase
import kotlinx.coroutines.launch
import presentation.base.BaseScreenStateModel
import presentation.test.auth.FirebaseTestContract.Action
import presentation.test.auth.FirebaseTestContract.Action.GetCurrentUser
import presentation.test.auth.FirebaseTestContract.Action.Loading
import presentation.test.auth.FirebaseTestContract.Effect
import presentation.test.auth.FirebaseTestContract.State

private const val TEST_LOGIN = "sergei.gulenko@gmail.com"
private const val TEST_PASSWORD = "marazm92"

class FirebaseTestScreenStateModel(
    private val getCurrentUserUseCase: FirebaseAuthGetCurrentUserUseCase,
    private val createUserWithEmailUseCase: FirebaseAuthCreateUserWithEmailUseCase,
    private val logoutUseCase: FirebaseAuthLogoutUseCase,
    private val loginWithEmailUseCase: FirebaseAuthLoginWithEmailUseCase,
    private val resetPasswordByEmailUseCase: FirebaseAuthResetPasswordByEmailUseCase,
) : BaseScreenStateModel<State, Action, Effect>() {

    init {
        getUser()
    }

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = when (action) {
        is Loading -> currentState.copy(
            isLoading = true,
            isError = false,
        )

        is GetCurrentUser -> currentState.copy(
            isLoading = false,
            isError = false,
            currentUser = action.currentUser,
        )

        is Action.Error -> currentState.copy(
            isLoading = false,
            isError = true,
            errorMessage = action.errorMessage,
        )
    }

    fun getUser() {
        launch {
            sendAction { Loading }
            runCatching {
                getCurrentUserUseCase.execute()
            }.onFailure {
                sendAction { Action.Error(it.message ?: "Unknown error") }
            }.onSuccess {
                sendAction { GetCurrentUser(it) }
            }
        }
    }

    fun createOrLogin() {
        launch {
            sendAction { Loading }
            runCatching {
                createUserWithEmailUseCase.execute(TEST_LOGIN, TEST_PASSWORD)
            }.onFailure {
                if (it is FirebaseAuthUserCollisionException) {
                    login()
                } else {
                    sendAction { Action.Error(it.message ?: "Unknown error") }
                }
            }.onSuccess {
                getUser()
            }
        }
    }

    private fun login() {
        launch {
            sendAction { Loading }
            runCatching {
                loginWithEmailUseCase.execute(TEST_LOGIN, TEST_PASSWORD)
            }.onFailure {
                sendAction { Action.Error(it.message ?: "Unknown error") }
            }.onSuccess {
                getUser()
            }
        }
    }

    fun logout() {
        launch {
            sendAction { Loading }
            runCatching {
                logoutUseCase.execute()
            }.onFailure {
                sendAction { Action.Error(it.message ?: "Unknown error") }
            }.onSuccess {
                getUser()
            }
        }
    }

    fun resetByEmail() {
        launch {
            sendAction { Loading }
            runCatching {
                resetPasswordByEmailUseCase.execute(TEST_LOGIN)
            }.onFailure {
                sendAction { Action.Error(it.message ?: "Unknown error") }
            }.onSuccess {
                getUser()
            }
        }
    }
}
