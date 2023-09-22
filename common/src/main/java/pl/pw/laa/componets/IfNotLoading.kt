package pl.pw.laa.componets

import androidx.compose.runtime.Composable

@Composable
fun IfNotLoading(isLoading: Boolean, content: @Composable () -> Unit) {
    if (isLoading)
        LoadingScreen()
    else
        content()
}