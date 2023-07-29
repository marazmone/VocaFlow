package presentation.screen.main

import domain.usecase.firebase.auth.FirebaseAuthLogoutUseCase
import domain.util.errorOrDefault
import domain.util.onFailureWithLog
import kotlinx.coroutines.launch
import presentation.base.BaseViewModel
import presentation.screen.main.MainContract.Action
import presentation.screen.main.MainContract.Action.Error
import presentation.screen.main.MainContract.Action.IDLE
import presentation.screen.main.MainContract.Action.Loading
import presentation.screen.main.MainContract.Effect
import presentation.screen.main.MainContract.Effect.NavigateLogout
import presentation.screen.main.MainContract.State

class MainViewModel(
    private val logoutUseCase: FirebaseAuthLogoutUseCase,
) : BaseViewModel<State, Action, Effect>() {

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = when (action) {
        is IDLE -> currentState.copy(
            isLoading = false,
            isError = false,
        )

        is Loading -> currentState.copy(
            isLoading = true,
            isError = false,
        )

        is Error -> currentState.copy(
            isLoading = false,
            isError = true,
            errorMessage = action.errorMessage,
        )
    }

    fun logout() {
        launch {
            sendAction { Loading }
            runCatching {
                logoutUseCase.execute()
            }.onFailureWithLog {
                sendAction { Error(it.message.errorOrDefault()) }
            }.onSuccess {
                sendAction { IDLE }
                sendEffect { NavigateLogout }
            }
        }
    }
}
