package presentation.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import presentation.ui.AppTheme

private val RoundedCornerShape = RoundedCornerShape(36.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputText(
    label: String,
    placeholder: String,
    inputValue: String,
    modifier: Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    maxLines: Int = Int.MAX_VALUE,
    onInputValueChange: (String) -> Unit,
) {
    var showPassword by remember { mutableStateOf(false) }

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
            singleLine = maxLines == 1,
            maxLines = maxLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction,
            ),
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
                disabledTextColor = AppTheme.colors.grayscale.gray100.copy(alpha = 0.5f),
                containerColor = AppTheme.colors.additional.background2,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            visualTransformation = if (keyboardType == KeyboardType.Password && showPassword.not()) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            trailingIcon = {
                if (keyboardType != KeyboardType.Password) return@TextField
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "hide_password"
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "hide_password"
                        )
                    }
                }
            }
        )
    }
}
