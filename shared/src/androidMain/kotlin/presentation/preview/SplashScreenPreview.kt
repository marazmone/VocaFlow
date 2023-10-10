package presentation.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import presentation.screen.splash.SplashScreen.SplashScreenWidget
import presentation.screen.splash.SplashScreenContract
import presentation.ui.AppTheme

@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
private fun SplashScreenWidget_Preview() {
    AppTheme {
        SplashScreenWidget(
            state = SplashScreenContract.State(),
        )
    }
}

@Preview(device = "id:pixel_5", showSystemUi = true)
@Composable
private fun SplashScreenWidgetError_Preview() {
    AppTheme {
        SplashScreenWidget(
            state = SplashScreenContract.State(
                isError = true,
                errorMessage = "Error message",
            ),
        )
    }
}