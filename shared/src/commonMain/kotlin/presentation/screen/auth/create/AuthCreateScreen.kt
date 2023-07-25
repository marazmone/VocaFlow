package presentation.screen.auth.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.statusBarsPadding
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.text.getString
import presentation.ui.AppTheme
import presentation.ui.composable.InputText

internal object AuthCreateScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val viewModel by inject<AuthCreateViewModel>()

        AuthCreateScreenWidget()
    }

    @Composable
    fun AuthCreateScreenWidget() {
        Box(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize()
                .background(AppTheme.colors.additional.background),
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
                    inputValue = "",
                    onInputValueChange = {},
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                )
            }
        }
    }
}
