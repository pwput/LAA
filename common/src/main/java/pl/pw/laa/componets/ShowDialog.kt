package pl.pw.laa.componets

import androidx.compose.runtime.Composable

@Composable
fun ShowDialog(isVisible: Boolean, content: @Composable () -> Unit) {
    if (isVisible)
        content()
}