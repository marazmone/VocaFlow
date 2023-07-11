package presentation.screen.intro

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen

internal object IntroScreen : Screen {

    // Temporary intro screen
    @Composable
    override fun Content() {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Blue),
        ) {
            Text(
                text = "Intro",
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}