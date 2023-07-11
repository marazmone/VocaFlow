package presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.screen.intro.IntroScreen

internal object SplashScreen : Screen {

    // Temporary splash screen
    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val coroutineScope = rememberCoroutineScope()
        LaunchedEffect(Unit) {
            coroutineScope.launch {
                delay(2_000L)
                mainNavigator.replace(IntroScreen)
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
                .background(Color.Green),
        ) {
            Text(
                text = "Splash",
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}