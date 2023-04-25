package pl.pw.laa.presentation.audioTest.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.domain.Letter
import pl.pw.laa.presentation.audioTest.AudioTestState
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

val paddingValues = PaddingValues(32.dp,0.dp)

@Composable
fun AnswersBox(
    state: AudioTestState,
    onAnswer: (Letter) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (!state.lettersList.isNullOrEmpty() && state.rightAnswer != null) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            for (i in 0 until state.lettersList.size - 1 step 2) {
                Row(
                    modifier = Modifier.weight(1f).padding(paddingValues),
                    horizontalArrangement = Arrangement.spacedBy(32.dp),
                ) {
                    AnswerButton(
                        form = state.lettersList[i].final,
                        onClick = { onAnswer(state.lettersList[i]) },
                        modifier = Modifier.weight(1f),
                        cheats = state.isRightAnswer(i) && state.areCheatsOn,
                    )
                    AnswerButton(
                        form = state.lettersList[i + 1].final,
                        onClick = { onAnswer(state.lettersList[i + 1]) },
                        modifier = Modifier.weight(1f),
                        cheats = state.isRightAnswer(i + 1) && state.areCheatsOn,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AnswersBoxPreview() {
    LearnArabicAlphabetTheme() {
        Surface() {
            AnswersBox(state = AudioTestState(null, 0, 0, null), onAnswer = {})
        }
    }
}
