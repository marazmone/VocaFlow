import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import presentation.screen.splash.SplashScreen
import presentation.ui.AppTheme

@Composable
fun App() {
    AppTheme {
        Navigator(SplashScreen)
    }
}

expect fun getPlatformName(): String
