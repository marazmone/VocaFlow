package presentation.ui.composable.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import presentation.ui.composable.BackHandler

/**
 * @param onDismissRequest: () -> Unit
 * @param backgroundColor: Color
 * @param content: @Composable BoxScope.() -> Unit
 *
 * Need add dialog to top level in composable tree
 */
@Composable
fun Dialog(
    onDismissRequest: () -> Unit,
    backgroundColor: Color = Color.Black.copy(alpha = 0.5f),
    content: @Composable BoxScope.() -> Unit
) {
    BackHandler(enabled = true, onBack = onDismissRequest)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .clickable {
                onDismissRequest.invoke()
            },
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {}
        ) {
            content.invoke(this)
        }
    }
}
