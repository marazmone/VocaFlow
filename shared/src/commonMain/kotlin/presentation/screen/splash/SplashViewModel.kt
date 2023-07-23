package presentation.screen.splash

import domain.usecase.firebase.auth.FirebaseAuthGetCurrentUserUseCase
import kotlinx.coroutines.launch
import presentation.base.BaseViewModel
import presentation.screen.splash.SplashContract.Action
import presentation.screen.splash.SplashContract.Effect
import presentation.screen.splash.SplashContract.State

class SplashViewModel(
    private val getCurrentUserUseCase: FirebaseAuthGetCurrentUserUseCase,
) : BaseViewModel<State, Action, Effect>() {

    init {
        checkAuth()
    }

    override fun setInitialState(): State = State()

    override fun onReduceState(action: Action): State = State()

    private fun checkAuth() {
        launch {
            runCatching {
                getCurrentUserUseCase.execute()
            }
        }
    }
}
