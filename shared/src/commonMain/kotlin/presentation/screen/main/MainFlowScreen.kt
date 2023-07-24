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
import presentation.ui.AppTheme

internal object MainFlowScreen : Screen {

    @Composable
    override fun Content() {
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
            }
        }
    }
}
