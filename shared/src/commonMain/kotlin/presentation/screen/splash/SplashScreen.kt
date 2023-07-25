package presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.moriatsushi.insetsx.statusBarsPadding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.screen.intro.IntroScreen
import presentation.ui.AppTheme

internal object SplashScreen : Screen {

    // Temporary splash screen
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val mainNavigator = LocalNavigator.currentOrThrow
        val coroutineScope = rememberCoroutineScope()
        LaunchedEffect(Unit) {
            coroutineScope.launch {
                delay(2_000L)
                mainNavigator.replace(IntroScreen)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppTheme.colors.main.primary)
                .statusBarsPadding(),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 110.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box {
                    Image(
                        painter = painterResource(res = "logo.xml"),
                        contentDescription = "image description",
                        contentScale = ContentScale.None
                    )
                    Image(
                        painter = painterResource(res = "ic_brain.xml"),
                        contentDescription = "image description",
                        contentScale = ContentScale.None,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Text(
                    text = "VocaFlow",
                    style = AppTheme.typography.h4Bold,
                    color = AppTheme.colors.additional.white,
                    modifier = Modifier.padding(top = 24.dp)
                )
            }
        }
    }
}