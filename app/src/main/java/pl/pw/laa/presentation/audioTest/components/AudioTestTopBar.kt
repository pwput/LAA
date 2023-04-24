package pl.pw.laa.presentation.audioTest.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pl.pw.laa.presentation.audioTest.AudioTestState

@Composable
fun AudioTestTopBar(
    state: AudioTestState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth(1f).wrapContentHeight(),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Column() {
            Text(text = "Score: ${state.score}")
            Text(text = "Mistakes: ${state.mistakes}")
        }
    }
}
