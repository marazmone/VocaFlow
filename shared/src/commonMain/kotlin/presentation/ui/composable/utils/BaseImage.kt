package presentation.ui.composable.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalInspectionMode
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BaseImage(
    resourcePath: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    mockShape: Shape = CircleShape,
    mockColor: Color = Color.Blue,
) {
    if (LocalInspectionMode.current) {
        Box(
            modifier = modifier
                .clip(mockShape)
                .background(mockColor)
        )
    } else {
        Image(
            painterResource(resourcePath),
            contentDescription,
            modifier = modifier
        )
    }
}