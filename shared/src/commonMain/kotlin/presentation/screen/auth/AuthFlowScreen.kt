package presentation.screen.auth

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import presentation.screen.auth.create.AuthCreateScreen

internal object AuthFlowScreen : Screen {

    @Composable
    override fun Content() {
        Navigator(AuthCreateScreen)
    }
}
