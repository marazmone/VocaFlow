package presentation.preview.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.ui.AppTheme
import presentation.ui.composable.auth.CreateOrLoginText

@Preview(showBackground = true)
@Composable
fun CreateOrLoginTextPreview() {
    AppTheme {
        CreateOrLoginText(
            onClick = {},
        )
    }
}
