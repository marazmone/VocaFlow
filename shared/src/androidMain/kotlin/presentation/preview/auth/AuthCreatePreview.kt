package presentation.preview.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.emptyFlow
import presentation.screen.auth.create.AuthCreateContract
import presentation.screen.auth.create.AuthCreateScreen.AuthCreateScreenWidget
import presentation.ui.AppTheme

@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
fun AuthCreateScreenPreview() {
    AppTheme {
        AuthCreateScreenWidget(
            state = AuthCreateContract.State(),
            effects = emptyFlow(),
            onUpdateEmail = {},
            onUpdatePassword = {},
            onCloseErrorPasswordDialog = {},
            onTryCreateAccount = {},
        )
    }
}
