package presentation.screen.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.statusBarsPadding
import domain.util.listen
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.screen.auth.composable.AuthErrorDialog
import presentation.screen.auth.composable.LoginOrCreateText
import presentation.screen.auth.composable.TermsText
import presentation.screen.auth.create.AuthCreateScreen
import presentation.screen.auth.forgot.AuthForgotPasswordScreen
import presentation.screen.main.MainScreen
import presentation.text.getString
import presentation.ui.AppTheme
import presentation.ui.composable.FullscreenLoader
import presentation.ui.composable.InputText
import presentation.ui.composable.PrimaryButton

internal object AuthLoginScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val viewModel by inject<AuthLoginViewModel>()

        AuthLoginScreenWidget(
            state = viewModel.state.value,
            effects = viewModel.effects,
            onUpdateEmail = {
                viewModel.updateEmail(it)
            },
            onUpdatePassword = {
                viewModel.updatePassword(it)
            },
            onLogIn = {
                viewModel.login()
            },
            onNavigationMainFlow = {
                mainNavigator.replace(MainScreen)
            },
            onNavigationCreateAccountFlow = {
                viewModel.resetState()
                mainNavigator.replace(AuthCreateScreen)
            },
            onClickForgot = {
                viewModel.resetState()
                mainNavigator.push(AuthForgotPasswordScreen)
            },
            onResetState = {
                viewModel.resetState()
            },
        )
    }

    @Composable
    fun AuthLoginScreenWidget(
        state: AuthLoginContract.State,
        effects: Flow<AuthLoginContract.Effect>,
        onUpdateEmail: (String) -> Unit,
        onUpdatePassword: (String) -> Unit,
        onLogIn: () -> Unit,
        onNavigationMainFlow: () -> Unit,
        onNavigationCreateAccountFlow: () -> Unit,
        onClickForgot: () -> Unit,
        onResetState: () -> Unit,
    ) {
        effects.listen { effect ->
            when (effect) {
                is AuthLoginContract.Effect.NavigateToMainFlow -> {
                    onNavigationMainFlow.invoke()
                }
            }
        }

        FullscreenLoader(isLoading = state.isLoading) {
            Surface {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppTheme.colors.additional.background)
                        .statusBarsPadding(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Spacer(modifier = Modifier.height(56.dp))
                        Text(
                            text = getString("login_account_title"),
                            modifier = Modifier
                                .fillMaxWidth(),
                            style = AppTheme.typography.h5Semi,
                            color = AppTheme.colors.grayscale.gray100,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = getString("login_account_description"),
                            modifier = Modifier
                                .padding(horizontal = 64.dp)
                                .fillMaxWidth(),
                            style = AppTheme.typography.bodyMediumMedium,
                            color = AppTheme.colors.grayscale.gray40,
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(36.dp))
                        InputText(
                            label = getString("email"),
                            placeholder = getString("email"),
                            maxLines = 1,
                            imeAction = ImeAction.Next,
                            keyboardType = KeyboardType.Email,
                            inputValue = state.email,
                            onInputValueChange = {
                                onUpdateEmail.invoke(it)
                            },
                            modifier = Modifier
                                .padding(horizontal = 24.dp)
                                .fillMaxWidth(),
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        InputText(
                            label = getString("password"),
                            placeholder = getString("password"),
                            maxLines = 1,
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done,
                            inputValue = state.password,
                            onInputValueChange = {
                                onUpdatePassword.invoke(it)
                            },
                            modifier = Modifier
                                .padding(horizontal = 24.dp)
                                .fillMaxWidth(),
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = getString("forgot_password"),
                            textAlign = TextAlign.End,
                            color = AppTheme.colors.main.primary,
                            style = AppTheme.typography.bodySmallMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp)
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() }
                                ) {
                                    onClickForgot.invoke()
                                },
                        )
                        Spacer(modifier = Modifier.height(34.dp))
                        PrimaryButton(
                            enabled = state.buttonEnabled,
                            text = getString("log_in"),
                            onClick = {
                                onLogIn.invoke()
                            },
                            modifier = Modifier
                                .padding(horizontal = 24.dp)
                                .fillMaxWidth()
                                .height(56.dp),
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        LoginOrCreateText(
                            onClick = {
                                onNavigationCreateAccountFlow.invoke()
                            },
                        )
                    }
                    TermsText(
                        onClick = {},
                    )
                }
                if (state.isError) {
                    AuthErrorDialog(
                        text = state.errorMessage,
                    ) {
                        onResetState.invoke()
                    }
                }
            }
        }
    }
}
