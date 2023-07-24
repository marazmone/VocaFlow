package presentation.preview.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.screen.auth.create.AuthCreateScreen.AuthCreateScreenWidget
import presentation.ui.AppTheme

@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
fun AuthCreateScreenPreview() {
    AppTheme {
        AuthCreateScreenWidget()
    }
}
