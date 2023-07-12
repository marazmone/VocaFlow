import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = I_OS_PLATFORM_NAME

fun MainViewController() = ComposeUIViewController { App() }

private const val I_OS_PLATFORM_NAME = "iOS"
