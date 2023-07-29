package presentation.screen.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import org.koin.core.component.KoinComponent
import presentation.ui.AppTheme

internal object AuthLoginScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        AuthLoginScreenWidget()
    }

    @Composable
    fun AuthLoginScreenWidget() {
        Box(
            modifier = Modifier
                .background(color = AppTheme.colors.additional.background)
        ) {
            Text(
                text = "AuthLoginScreen",
                modifier = Modifier
                    .align(alignment = Alignment.Center),
            )
        }
    }
}
