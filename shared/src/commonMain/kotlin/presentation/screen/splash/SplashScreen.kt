package presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import domain.util.listen
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.screen.auth.create.AuthCreateScreen
import presentation.screen.main.MainScreen
import presentation.screen.splash.SplashContract.Effect
import presentation.screen.splash.SplashContract.State
import presentation.ui.AppTheme

@Suppress("MagicNumber")
internal object SplashScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val viewModel by inject<SplashViewModel>()

        SplashScreenWidget(
            state = viewModel.state.value,
            effects = viewModel.effects,
            onNavigateToAuthFlow = {
                mainNavigator.replace(AuthCreateScreen)
            },
            onNavigateToMainFlow = {
                mainNavigator.replace(MainScreen)
            }
        )
    }

    @Composable
    private fun SplashScreenWidget(
        state: State,
        effects: Flow<Effect>,
        onNavigateToAuthFlow: () -> Unit,
        onNavigateToMainFlow: () -> Unit,
    ) {
        effects.listen { effect ->
            when (effect) {
                Effect.NavigateToAuthFlow -> {
                    onNavigateToAuthFlow.invoke()
                }

                Effect.NavigateToMainFlow -> {
                    onNavigateToMainFlow.invoke()
                }
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
                .background(AppTheme.colors.main.primary),
        ) {
            when {
                state.isError -> {
                    Column(
                        modifier = Modifier.align(Alignment.BottomCenter),
                    ) {
                        Text(
                            text = state.errorMessage,
                            color = AppTheme.colors.alerts.error,
                            style = AppTheme.typography.h4Bold,
                        )
                    }
                }
            }
        }
    }
}
