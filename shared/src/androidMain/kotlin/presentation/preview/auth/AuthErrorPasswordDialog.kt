package presentation.preview.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import presentation.screen.auth.composable.AuthErrorPasswordDialog
import presentation.ui.AppTheme

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true, showSystemUi = true)
@Composable
fun InfoDialogPreview() {
    AppTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AuthErrorPasswordDialog(
                onDismissRequest = {},
            )
        }
    }
}
