package pl.pw.laa.common.componets

import androidx.compose.runtime.Composable

@Composable
fun ShowDialog(isVisible: Boolean, content: @Composable () -> Unit) {
	if (isVisible)
		content()
}