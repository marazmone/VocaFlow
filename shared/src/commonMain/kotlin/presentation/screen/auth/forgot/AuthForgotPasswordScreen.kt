package presentation.screen.auth.forgot

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.navigationBarsPadding
import com.moriatsushi.insetsx.statusBarsPadding
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.text.getString
import presentation.ui.AppTheme
import presentation.ui.composable.FullscreenLoader
import presentation.ui.composable.InputText
import presentation.ui.composable.PrimaryButton
import presentation.ui.icons.IconArrowLeft

object AuthForgotPasswordScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val viewModel by inject<AuthForgotPasswordViewModel>()

        AuthForgotPasswordScreenWidget(
            state = AuthForgotPasswordContract.State(),
            onClickBack = {
                mainNavigator.pop()
            },
            onUpdateEmail = { viewModel.updateEmail(it) },
            onContinue = {},
        )
    }

    @Composable
    fun AuthForgotPasswordScreenWidget(
        state: AuthForgotPasswordContract.State,
        onClickBack: () -> Unit,
        onUpdateEmail: (String) -> Unit,
        onContinue: () -> Unit,
    ) {
        FullscreenLoader(isLoading = state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppTheme.colors.additional.background)
                    .statusBarsPadding()
                    .navigationBarsPadding(),
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 24.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color = AppTheme.colors.grayscale.gray90)
                        .clickable {
                            onClickBack.invoke()
                        },
                ) {
                    Icon(
                        imageVector = IconArrowLeft.icon,
                        contentDescription = null,
                        tint = AppTheme.colors.additional.text,
                        modifier = Modifier
                            .align(Alignment.Center),
                    )
                }
                Column {
                    Spacer(modifier = Modifier.padding(top = 68.dp))
                    Text(
                        text = getString("auth_forgot_password"),
                        style = AppTheme.typography.h5Semi,
                        color = AppTheme.colors.additional.text,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 50.dp),
                    )
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    Text(
                        text = getString("auth_forgot_password_description"),
                        style = AppTheme.typography.bodyMediumMedium,
                        color = AppTheme.colors.grayscale.gray40,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 50.dp),
                    )
                    Spacer(modifier = Modifier.padding(top = 36.dp))
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
                    Spacer(modifier = Modifier.padding(top = 66.dp))
                    PrimaryButton(
                        enabled = state.buttonEnabled,
                        text = getString("continue_button"),
                        onClick = {
                            onContinue.invoke()
                        },
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                            .height(56.dp),
                    )
                }
            }
        }
    }
}
