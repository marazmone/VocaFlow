package presentation.preview.auth

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.screen.auth.forgot.AuthForgotPasswordContract.State
import presentation.screen.auth.forgot.AuthForgotPasswordScreen.AuthForgotPasswordScreenWidget
import presentation.ui.AppTheme

@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
fun AuthForgotPasswordScreenWidgetPreview() {
    AppTheme {
        AuthForgotPasswordScreenWidget(
            state = State(),
            onClickBack = {},
            onUpdateEmail = {},
            onContinue = {},
        )
    }
}

@Preview(
    device = "id:pixel_5", showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun AuthForgotPasswordScreenWidgetPreview_Dark() {
    AppTheme {
        AuthForgotPasswordScreenWidget(
            state = State(),
            onClickBack = {},
            onUpdateEmail = {},
            onContinue = {},
        )
    }
}
