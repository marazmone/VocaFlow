package presentation.test.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.moriatsushi.insetsx.navigationBarsPadding
import com.moriatsushi.insetsx.statusBarsPadding
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.ui.AppTheme

internal object FirebaseTestScreen : Screen, KoinComponent {

    @Composable
    override fun Content() {
        val viewStateModel by inject<FirebaseTestScreenStateModel>()
        val state = viewStateModel.state.value
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.additional.background)
                .statusBarsPadding()
                .navigationBarsPadding(),
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center),
                    )
                }

                state.isError -> {
                    Text(
                        text = state.errorMessage,
                        color = AppTheme.colors.grayscale.gray100,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .clickable {
                                viewStateModel.getUser()
                            },
                    )
                }

                state.currentUser == null -> {
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center),
                    ) {
                        Text(
                            text = "No user",
                            color = AppTheme.colors.grayscale.gray100,
                            modifier = Modifier
                                .padding(16.dp),
                        )
                        Text(
                            text = "Login to Firebase",
                            color = AppTheme.colors.grayscale.gray100,
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    viewStateModel.createOrLogin()
                                },
                        )
                        Text(
                            text = "Reset password by email",
                            color = AppTheme.colors.grayscale.gray100,
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    viewStateModel.resetByEmail()
                                },
                        )
                    }
                }

                else -> {
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center),
                    ) {
                        Text(
                            text = "User id: ${state.currentUser.uid}",
                            color = AppTheme.colors.grayscale.gray100,
                            modifier = Modifier
                                .padding(16.dp),
                        )
                        Text(
                            text = "Logout from Firebase",
                            color = AppTheme.colors.grayscale.gray100,
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    viewStateModel.logout()
                                },
                        )
                    }
                }
            }
        }
    }
}
