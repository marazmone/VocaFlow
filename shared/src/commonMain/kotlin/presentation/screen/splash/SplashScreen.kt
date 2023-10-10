package presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import domain.util.listen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.screen.auth.composable.AuthErrorDialog
import presentation.screen.auth.create.AuthCreateScreen
import presentation.screen.main.MainScreen
import presentation.screen.splash.SplashScreenContract.Effect
import presentation.screen.splash.SplashScreenContract.State
import presentation.text.getString
import presentation.ui.AppTheme
import presentation.ui.composable.utils.BaseImage

@Suppress("MagicNumber")
internal object SplashScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val viewModel by inject<SplashViewModel>()

        viewModel.effects.listen { effect ->
            when (effect) {
                Effect.NavigateToAuthFlow -> {
                    mainNavigator.replace(AuthCreateScreen)
                }

                Effect.NavigateToMainFlow -> {
                    mainNavigator.replace(MainScreen)
                }
            }
        }

        SplashScreenWidget(
            state = viewModel.state.value,
        )
    }

    @Composable
    fun SplashScreenWidget(
        state: State,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(AppTheme.colors.main.primary),
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 150.dp)
                    .align(Alignment.TopCenter),
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                ) {
                    BaseImage(
                        resourcePath = "ic_splash_logo.png",
                        modifier = Modifier
                            .size(217.dp)
                            .align(Alignment.Center),
                    )
                    BaseImage(
                        resourcePath = "ic_splash_icon.png",
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.Center),
                        mockColor = Color.Red,
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = getString("app_name"),
                    style = AppTheme.typography.h4Medium,
                    color = AppTheme.colors.additional.white,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                )
            }
            when {
                state.isError -> {
                    AuthErrorDialog(text = state.errorMessage)
                }
            }
        }
    }
}
