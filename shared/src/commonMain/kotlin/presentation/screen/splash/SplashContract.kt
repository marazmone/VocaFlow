package presentation.screen.splash

import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState

class SplashContract {

    class State : BaseViewState

    sealed interface Action : BaseViewAction

    sealed interface Effect : BaseViewEffect {

        object NavigateToAuthFlow : Effect

        object NavigateToMainFlow : Effect

        object NavigateToIntroFlow : Effect
    }
}
