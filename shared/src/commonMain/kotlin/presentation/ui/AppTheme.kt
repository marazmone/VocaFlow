package presentation.ui

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalTypography = staticCompositionLocalOf { appTypography }

internal val LocalColors = staticCompositionLocalOf { lightColors }

internal object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Immutable
private object AppRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = LocalContentColor.current,
        lightTheme = AppTheme.colors.isLight
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = LocalContentColor.current,
        lightTheme = AppTheme.colors.isLight
    )
}

@Composable
fun AppTheme(
    colors: AppColors = if (isSystemInDarkTheme()) darkColors else lightColors,
    typography: AppTypography = AppTheme.typography,
    content: @Composable () -> Unit
) {
    val rippleIndication = rememberRipple()

    CompositionLocalProvider(
        LocalColors provides colors,
        LocalIndication provides rippleIndication,
        LocalRippleTheme provides AppRippleTheme,
        LocalTypography provides typography,
    ) {
        content.invoke()
    }
}
