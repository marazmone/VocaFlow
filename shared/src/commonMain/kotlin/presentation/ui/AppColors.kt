package presentation.ui

import androidx.compose.ui.graphics.Color

data class AppColors(
    val main: MainColors,
    val alerts: AlertColors,
    val additional: AdditionalColors,
    val grayscale: GrayscaleColors,
    val isLight: Boolean,
) {

    data class MainColors(
        val primary: Color,
        val secondary: Color,
    )

    data class AlertColors(
        val error: Color,
        val warning: Color,
        val success: Color,
    )

    data class AdditionalColors(
        val white: Color,
        val background: Color,
        val background2: Color,
        val backgroundBlue: Color,
        val line: Color,
        val text: Color,
    )

    data class GrayscaleColors(
        val gray10: Color,
        val gray20: Color,
        val gray30: Color,
        val gray40: Color,
        val gray50: Color,
        val gray60: Color,
        val gray70: Color,
        val gray80: Color,
        val gray90: Color,
        val gray100: Color,
    )
}

internal val lightColors = AppColors(
    main = AppColors.MainColors(
        primary = Color(0xFF4864E1),
        secondary = Color(0xFFF984A0),
    ),
    alerts = AppColors.AlertColors(
        error = Color(0xFFE88888),
        warning = Color(0xFFFACC15),
        success = Color(0xFF4EBE88),
    ),
    additional = AppColors.AdditionalColors(
        white = Color(0xFFFFFFFF),
        background = Color(0xFFFAFAFA),
        background2 = Color(0xFFFAFAFA),
        backgroundBlue = Color(0xFFD8E5FE),
        line = Color(0xFFDDDDDD),
        text = Color(0xFF000000),
    ),
    grayscale = AppColors.GrayscaleColors(
        gray10 = Color(0xFFF2F2F7),
        gray20 = Color(0xFFD1D1D6),
        gray30 = Color(0xFFFFCD1A),
        gray40 = Color(0xFFAEAEB2),
        gray50 = Color(0xFFFFCD1A),
        gray60 = Color(0xFF09080D),
        gray70 = Color(0xFF08070C),
        gray80 = Color(0xFF07060A),
        gray90 = Color(0xFFFFFFFF),
        gray100 = Color(0xFF1C1C1E),
    ),
    isLight = true,
)

internal val darkColors = AppColors(
    main = AppColors.MainColors(
        primary = Color(0xFF4864E1),
        secondary = Color(0xFFF984A0),
    ),
    alerts = AppColors.AlertColors(
        error = Color(0xFFE88888),
        warning = Color(0xFFFACC15),
        success = Color(0xFF4EBE88),
    ),
    additional = AppColors.AdditionalColors(
        white = Color(0xFFFFFFFF),
        background = Color(0xFF1C1C1E),
        background2 = Color(0xFF2C2C2E),
        backgroundBlue = Color(0xFFDDDDDD),
        line = Color(0xFF3A3A3C),
        text = Color(0xFFFFFFFF),
    ),
    grayscale = AppColors.GrayscaleColors(
        gray10 = Color(0xFFF2F2F7),
        gray20 = Color(0xFFD1D1D6),
        gray30 = Color(0xFFFFCD1A),
        gray40 = Color(0xFFAEAEB2),
        gray50 = Color(0xFFFFCD1A),
        gray60 = Color(0xFF09080D),
        gray70 = Color(0xFF08070C),
        gray80 = Color(0xFF3A3A3C),
        gray90 = Color(0xFF2C2C2E),
        gray100 = Color(0xFFFFFFFF),
    ),
    isLight = false,
)
