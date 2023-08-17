package presentation.preview.auth

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.emptyFlow
import presentation.screen.auth.login.AuthLoginContract
import presentation.screen.auth.login.AuthLoginScreen.AuthLoginScreenWidget
import presentation.ui.AppTheme

@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
fun AuthLoginScreenPreview() {
    AppTheme {
        AuthLoginScreenWidget(
            state = AuthLoginContract.State(),
            effects = emptyFlow(),
            onUpdateEmail = {},
            onUpdatePassword = {},
            onNavigationMainFlow = {},
            onNavigationCreateAccountFlow = {},
            onLogIn = {},
        )
    }
}

@Preview(
    device = "id:pixel_5", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun AuthLoginScreenPreview_Dark() {
    AppTheme {
        AuthLoginScreenWidget(
            state = AuthLoginContract.State(),
            effects = emptyFlow(),
            onUpdateEmail = {},
            onUpdatePassword = {},
            onNavigationMainFlow = {},
            onNavigationCreateAccountFlow = {},
            onLogIn = {},
        )
    }
}
