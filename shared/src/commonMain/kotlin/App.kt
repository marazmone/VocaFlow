import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import presentation.screen.splash.SplashScreen
import presentation.test.auth.FirebaseTestScreen
import presentation.ui.AppTheme

@Composable
fun App() {
    AppTheme {
        // TODO: Remove this after tes firebase auth
        if (true) {
            Navigator(FirebaseTestScreen)
        } else {
            Navigator(SplashScreen)
        }
    }
}

expect fun getPlatformName(): String
