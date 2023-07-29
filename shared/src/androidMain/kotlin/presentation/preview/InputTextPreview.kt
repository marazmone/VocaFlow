package presentation.preview

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import presentation.ui.composable.InputText

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun InputTextPreview() {
    InputText(
        label = "Email",
        placeholder = "Enter your email",
        inputValue = "",
        onInputValueChange = {},
        modifier = Modifier
            .fillMaxWidth(),
    )
}
