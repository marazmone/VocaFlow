package presentation.ui.composable.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.moriatsushi.insetsx.navigationBarsPadding
import presentation.text.getString
import presentation.ui.AppTheme

@Composable
fun BoxScope.TermsText(
    onClick: () -> Unit,
) {
    Text(
        modifier = Modifier
            .align(Alignment.BottomCenter)
            .navigationBarsPadding()
            .padding(bottom = 24.dp)
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(vertical = 12.dp),
        text = buildAnnotatedString {
            append(getString("terms_part_1"))
            append(" ")
            withStyle(
                SpanStyle(
                    color = AppTheme.colors.main.primary,
                    textDecoration = TextDecoration.None,
                )
            ) {
                append(getString("terms_part_2"))
            }
            append(" ")
            append(getString("terms_part_3"))
            append(" ")
            withStyle(
                SpanStyle(
                    color = AppTheme.colors.main.primary,
                    textDecoration = TextDecoration.None,
                )
            ) {
                append(getString("terms_part_4"))
            }
        },
        color = AppTheme.colors.grayscale.gray40,
        style = AppTheme.typography.bodyMediumMedium,
        textAlign = TextAlign.Center,
    )
}
