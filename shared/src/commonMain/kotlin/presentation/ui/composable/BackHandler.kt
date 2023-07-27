package presentation.ui.composable

import androidx.compose.runtime.Composable

@Composable
internal expect fun BackHandler(enabled: Boolean, onBack: () -> Unit)
