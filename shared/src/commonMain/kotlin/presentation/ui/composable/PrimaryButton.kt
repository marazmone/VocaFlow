package presentation.ui.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import presentation.ui.AppTheme

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(46.dp),
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = AppTheme.colors.additional.white,
            containerColor = AppTheme.colors.main.primary,
            disabledContentColor = AppTheme.colors.grayscale.gray40,
            disabledContainerColor = AppTheme.colors.grayscale.gray10,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier,
    ) {
        Text(text)
    }
}

@Composable
fun PrimaryButton_Preview() {
    AppTheme {
        PrimaryButton(
            text = "Primary Button",
            onClick = {},
        )
    }
}
