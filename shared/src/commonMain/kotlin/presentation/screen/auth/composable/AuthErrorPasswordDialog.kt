package presentation.screen.auth.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.text.getString
import presentation.ui.AppTheme
import presentation.ui.composable.PrimaryButton
import presentation.ui.composable.dialog.Dialog

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AuthErrorDialog(
    text: String,
    onDismissRequest: () -> Unit,
) {
    Dialog(onDismissRequest) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .background(color = AppTheme.colors.additional.background, shape = RoundedCornerShape(24.dp))
                .border(width = 1.dp, color = AppTheme.colors.additional.line, shape = RoundedCornerShape(24.dp))
                .align(Alignment.Center),
        ) {
            if (LocalInspectionMode.current) {
                Box(
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .size(60.dp)
                        .background(Color.Blue)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                Image(
                    painterResource(res = "image_rejected.png"),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .size(60.dp)
                        .align(Alignment.CenterHorizontally),
                )
            }
            Text(
                text = text,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 32.dp)
                    .align(Alignment.CenterHorizontally),
                style = AppTheme.typography.bodyMediumMedium,
                color = AppTheme.colors.grayscale.gray100,
                textAlign = TextAlign.Center,
            )
            PrimaryButton(
                text = getString("close"),
                modifier = Modifier
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 32.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .align(Alignment.CenterHorizontally),
                onClick = onDismissRequest,
            )
        }
    }
}
