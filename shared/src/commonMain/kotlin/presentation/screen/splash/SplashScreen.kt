package presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.screen.intro.IntroScreen
import presentation.ui.AppTheme

@Suppress("MagicNumber")
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
                .background(AppTheme.colors.additional.background),
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Splash Screen",
                    style = AppTheme.typography.h4Bold,
                    color = AppTheme.colors.grayscale.gray100,
                )
                Text(
                    text = "Sample",
                    style = AppTheme.typography.bodyMediumMedium,
                    color = AppTheme.colors.grayscale.gray40,
                )
            }
        }
    }
}
