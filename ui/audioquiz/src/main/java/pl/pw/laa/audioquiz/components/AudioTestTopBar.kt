package pl.pw.laa.audioquiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pl.pw.laa.audioquiz.AudioTestState

@Composable
fun AudioTestTopBar(
    state: AudioTestState,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth(1f).background(MaterialTheme.colorScheme.background).wrapContentHeight(),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier.fillMaxWidth(1f)) {
            Text(text = "Mistakes: ${state.mistakes}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
            Text(text = "Score: ${state.score}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
        }
    }
}
