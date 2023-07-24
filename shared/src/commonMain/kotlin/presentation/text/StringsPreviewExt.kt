package presentation.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode

@Composable
fun getString(key: String): String {
    return if (LocalInspectionMode.current) {
        key
    } else {
        Strings.get(key)
    }
}

@Composable
fun getString(key: String, quantity: Int): String {
    return if (LocalInspectionMode.current) {
        key
    } else {
        Strings.get(key)
    }
}

@Composable
fun getString(key: String, vararg args: Any): String {
    return if (LocalInspectionMode.current) {
        key
    } else {
        Strings.format(key)
    }
}
