package presentation.screen.intro

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import presentation.screen.model.IntroPageItem
import presentation.ui.AppTheme

internal object IntroScreen : Screen {

    // Temporary intro screen
    @OptIn(ExperimentalFoundationApi::class, ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val introItems = remember {
            listOf(
                IntroPageItem(
                    "im_intro_page_1.png",
                    title = " Can be accessed from anywhere at any time",
                    description = "The essential language learning tools and resources you need to seamlessly transition into mastering a new language"
                ),
                IntroPageItem(
                    "im_intro_page_2.png",
                    title = "Can be accessed from anywhere at any time",
                    description = "The essential language learning tools and resources you need to seamlessly transition into mastering a new language"
                ),
                IntroPageItem(
                    "im_intro_page_3.png",
                    title = " Can be accessed from anywhere at any time",
                    description = "The essential language learning tools and resources you need to seamlessly transition into mastering a new language"
                )
            )
        }
        val pagerState = rememberPagerState()
        Box(modifier = Modifier.fillMaxSize()) {
            HorizontalPager(
                pageCount = introItems.size,
                state = pagerState,
                userScrollEnabled = true,
                modifier = Modifier.padding(bottom = 114.dp)
            ) { page ->
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Image(
                        painter = painterResource(introItems[page].imageRes),
                        modifier = Modifier.padding(top = 174.dp).height(249.dp),
                        contentScale = ContentScale.Fit,
                        contentDescription = "image description",
                    )
                    Text(
                        text = introItems[page].title,
                        style = AppTheme.typography.h4Bold,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(start = 23.dp, end = 23.dp, top = 85.dp),
                        color = AppTheme.colors.grayscale.gray100,
                    )
                    Text(
                        text = introItems[page].description,
                        style = AppTheme.typography.bodyMediumMedium,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(start = 23.dp, end = 23.dp, top = 16.dp),
                        color = AppTheme.colors.grayscale.gray40
                    )
                }
            }
        }
    }
}