package presentation.test.auth

import domain.model.firebase.auth.FirebaseAuthUser
import presentation.base.BaseViewAction
import presentation.base.BaseViewEffect
import presentation.base.BaseViewState

class FirebaseTestContract {

    data class State(
        val currentUser: FirebaseAuthUser? = null,
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val errorMessage: String = "",
    ) : BaseViewState

    sealed interface Action : BaseViewAction {

        object Loading : Action

        data class GetCurrentUser(val currentUser: FirebaseAuthUser?) : Action

        data class Error(val errorMessage: String) : Action
    }

    sealed interface Effect : BaseViewEffect
}
