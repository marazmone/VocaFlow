package presentation.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import presentation.ui.AppTheme

private val RoundedCornerShape = RoundedCornerShape(36.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    label: String,
    placeholder: String,
    inputValue: String,
    onInputValueChange: (String) -> Unit,
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = label,
            style = AppTheme.typography.bodyMediumMedium,
            color = AppTheme.colors.grayscale.gray100,
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            placeholder = {
                Text(
                    text = placeholder,
                    style = AppTheme.typography.bodyMediumMedium,
                    color = AppTheme.colors.grayscale.gray40,
                )
            },
            value = inputValue,
            onValueChange = onInputValueChange,
            shape = RoundedCornerShape,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = AppTheme.colors.additional.line,
                    shape = RoundedCornerShape,
                ),
            colors = TextFieldDefaults.textFieldColors(
                AppTheme.colors.grayscale.gray100,
                containerColor = AppTheme.colors.additional.background2,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
        )
    }
}
