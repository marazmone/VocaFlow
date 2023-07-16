package presentation.test.auth

import domain.firebase.auth.FirebaseAuthUserCollisionException
import domain.usecase.firebase.auth.FirebaseAuthCreateUserWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthGetCurrentUserUseCase
import domain.usecase.firebase.auth.FirebaseAuthLoginWithEmailUseCase
import domain.usecase.firebase.auth.FirebaseAuthLogoutUseCase
import kotlinx.coroutines.launch
import presentation.base.BaseScreenStateModel
import presentation.test.auth.FirebaseTestContract.Action
import presentation.test.auth.FirebaseTestContract.Action.GetCurrentUser
import presentation.test.auth.FirebaseTestContract.Action.Loading
import presentation.test.auth.FirebaseTestContract.Effect
import presentation.test.auth.FirebaseTestContract.State

private const val TEST_LOGIN = "test@gmail.com"
private const val TEST_PASSWORD = "123456"

class FirebaseTestScreenStateModel(
    private val getCurrentUserUseCase: FirebaseAuthGetCurrentUserUseCase,
    private val createUserWithEmailUseCase: FirebaseAuthCreateUserWithEmailUseCase,
    private val logoutUseCase: FirebaseAuthLogoutUseCase,
    private val loginWithEmailUseCase: FirebaseAuthLoginWithEmailUseCase,
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

    private fun getUser() {
        launch {
            sendAction { Loading }
            val user = getCurrentUserUseCase.execute()
            sendAction { GetCurrentUser(user) }
        }
    }

    fun login() {
        launch {
            sendAction { Loading }
            runCatching {
                createUserWithEmailUseCase.execute(TEST_LOGIN, TEST_PASSWORD)
            }.onFailure {
                if (it is FirebaseAuthUserCollisionException) {
                    loginWithEmailUseCase.execute(TEST_LOGIN, TEST_PASSWORD)
                    getUser()
                } else {
                    sendAction { Action.Error(it.message ?: "Unknown error") }
                }
            }.onSuccess {
                getUser()
            }
        }
    }

    fun logout() {
        launch {
            sendAction { Loading }
            logoutUseCase.execute()
            getUser()
        }
    }
}
