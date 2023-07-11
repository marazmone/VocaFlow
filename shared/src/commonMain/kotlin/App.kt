import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import presentation.screen.splash.SplashScreen

@Composable
fun App() {
    Navigator(SplashScreen)
}

expect fun getPlatformName(): String