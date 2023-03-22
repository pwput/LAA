package pl.pw.laa.ui.audioTest

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.domain.Letter
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun AnswersBox(
    modifier: Modifier = Modifier,
    audioTestState: AudioTestState,
    onAnswer: (Letter) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        for (i in 0 until audioTestState.audioTestLettersList.size - 1 step 2) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                AnswerButton(
                    form = audioTestState.audioTestLettersList[i].final,
                    onClick = { onAnswer(audioTestState.audioTestLettersList[i]) },
                    modifier = Modifier.weight(1f),
                )
                AnswerButton(
                    form = audioTestState.audioTestLettersList[i + 1].final,
                    onClick = { onAnswer(audioTestState.audioTestLettersList[i + 1]) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Preview
@Composable
fun AnswersBoxPreview() {
    LearnArabicAlphabetTheme() {
        Surface() {
            AnswersBox(audioTestState = AudioTestState(), onAnswer = {})
        }
    }
}
