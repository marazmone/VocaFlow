package presentation.screen.splash

import domain.usecase.firebase.auth.FirebaseAuthGetCurrentUserUseCase
import domain.util.errorOrDefault
import domain.util.onFailureWithLog
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.base.BaseViewModel
import presentation.screen.splash.SplashScreenContract.Action
import presentation.screen.splash.SplashScreenContract.Effect
import presentation.screen.splash.SplashScreenContract.State

@Suppress("MagicNumber")
class SplashViewModel(
    private val getCurrentUserUseCase: FirebaseAuthGetCurrentUserUseCase,
) : BaseViewModel<State, Action, Effect>() {

    init {
        launch {
            delay(1_500L)
            checkAuth()
        }
    }

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = State()

    private fun checkAuth() {
        launch {
            runCatching {
                getCurrentUserUseCase.execute()
            }.onFailureWithLog {
                sendAction { Action.Error(it.message.errorOrDefault()) }
            }.onSuccess { authUser ->
                if (authUser == null) {
                    sendEffect { Effect.NavigateToAuthFlow }
                } else {
                    sendEffect { Effect.NavigateToMainFlow }
                }
            }
        }
    }
}
