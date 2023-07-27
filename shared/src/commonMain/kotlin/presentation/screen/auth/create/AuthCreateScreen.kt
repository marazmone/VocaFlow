package presentation.screen.auth.create

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.statusBarsPadding
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.screen.auth.composable.CreateOrLoginText
import presentation.screen.auth.composable.AuthErrorPasswordDialog
import presentation.screen.auth.composable.TermsText
import presentation.text.getString
import presentation.ui.AppTheme
import presentation.ui.composable.InputText
import presentation.ui.composable.PrimaryButton

internal object AuthCreateScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val viewModel by inject<AuthCreateViewModel>()

        AuthCreateScreenWidget(
            state = viewModel.state.value,
            effects = viewModel.effects,
            onUpdateEmail = { viewModel.updateEmail(it) },
            onUpdatePassword = { viewModel.updatePassword(it) },
            onCloseErrorPasswordDialog = { viewModel.closeErrorPasswordDialog() },
            onTryCreateAccount = { viewModel.tryCreateAccount() },
        )
    }

    @Composable
    fun AuthCreateScreenWidget(
        state: AuthCreateContract.State,
        effects: Flow<AuthCreateContract.Effect>,
        onUpdateEmail: (String) -> Unit,
        onUpdatePassword: (String) -> Unit,
        onCloseErrorPasswordDialog: () -> Unit,
        onTryCreateAccount: () -> Unit,
    ) {
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
                        text = getString("create_account_title"),
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = AppTheme.typography.h5Semi,
                        color = AppTheme.colors.grayscale.gray100,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = getString("create_account_description"),
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
                    Spacer(modifier = Modifier.height(68.dp))
                    PrimaryButton(
                        enabled = state.buttonEnabled,
                        text = getString("button_create_account"),
                        onClick = {
                            onTryCreateAccount.invoke()
                        },
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                            .height(56.dp),
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    CreateOrLoginText(
                        onClick = {},
                    )
                }
                TermsText(
                    onClick = {},
                )
            }
            if (state.showErrorPasswordDialog) {
                AuthErrorPasswordDialog(
                    onDismissRequest = {
                        onCloseErrorPasswordDialog.invoke()
                    }
                )
            }
        }
    }
}
