package presentation.screen.auth.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import presentation.text.getString
import presentation.ui.AppTheme

@Composable
fun CreateOrLoginText(
    onClick: () -> Unit,
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(vertical = 12.dp),
        text = buildAnnotatedString {
            append(getString("create_account_already_exist"))
            append(" ")
            withStyle(
                SpanStyle(
                    color = AppTheme.colors.main.primary,
                    textDecoration = TextDecoration.Underline,
                )
            ) {
                append(getString("log_in"))
            }
        },
        color = AppTheme.colors.grayscale.gray40,
        style = AppTheme.typography.bodyMediumMedium,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun LoginOrCreateText(
    onClick: () -> Unit,
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .clip(RoundedCornerShape(6.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(vertical = 12.dp),
        text = buildAnnotatedString {
            append(getString("do_not_have_account"))
            append(" ")
            withStyle(
                SpanStyle(
                    color = AppTheme.colors.main.primary,
                    textDecoration = TextDecoration.Underline,
                )
            ) {
                append(getString("create_here"))
            }
        },
        color = AppTheme.colors.grayscale.gray40,
        style = AppTheme.typography.bodyMediumMedium,
        textAlign = TextAlign.Center,
    )
}
