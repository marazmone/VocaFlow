package presentation.screen.main

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
import presentation.screen.main.MainContract.Effect
import presentation.screen.main.MainContract.State
import presentation.ui.AppTheme
import presentation.ui.composable.FullscreenLoader
import presentation.ui.composable.PrimaryButton

internal object MainScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val viewModel by inject<MainViewModel>()
        val navigator = LocalNavigator.currentOrThrow

        MainScreenWidget(
            state = viewModel.state.value,
            effects = viewModel.effects,
            onLogout = { viewModel.logout() },
            onNavigateLogout = {
                navigator.replace(AuthCreateScreen)
            },
        )
    }

    @Composable
    fun MainScreenWidget(
        state: State,
        effects: Flow<Effect>,
        onLogout: () -> Unit,
        onNavigateLogout: () -> Unit,
    ) {
        effects.listen { effect ->
            when (effect) {
                is Effect.NavigateLogout -> onNavigateLogout.invoke()
            }
        }

        FullscreenLoader(
            isLoading = state.isLoading
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(AppTheme.colors.additional.background),
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Main Screen",
                        style = AppTheme.typography.h4Bold,
                        color = AppTheme.colors.grayscale.gray100,
                    )
                    Text(
                        text = "Sample",
                        style = AppTheme.typography.bodyMediumMedium,
                        color = AppTheme.colors.grayscale.gray40,
                    )
                    PrimaryButton(
                        text = "Logout",
                        onClick = {
                            onLogout.invoke()
                        }
                    )
                }
            }
        }
    }
}
