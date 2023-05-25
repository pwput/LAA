package pl.pw.laa.presentation.audioTest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.data.model.Form
import pl.pw.laa.presentation.audioTest.AudioTestState
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

val paddingValues = PaddingValues(16.dp, 0.dp)

@Composable
fun AnswersBox(
    state: AudioTestState,
    onAnswer: (Form) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (!state.formsList.isNullOrEmpty() && state.rightAnswer != null) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min).background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            for (i in 0 until state.formsList.size - 1 step 2) {
                Row(
                    modifier = Modifier.weight(1f).background(MaterialTheme.colorScheme.background).padding(paddingValues),
                    horizontalArrangement = Arrangement.spacedBy(32.dp),
                ) {
                    AnswerButton(
                        form = state.formsList[i],
                        onClick = { onAnswer(state.formsList[i]) },
                        modifier = Modifier.weight(1f),
                        cheats = state.isRightAnswer(i) && state.areCheatsOn,
                    )
                    AnswerButton(
                        form = state.formsList[i + 1],
                        onClick = { onAnswer(state.formsList[i + 1]) },
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
            AnswersBox(
                state = AudioTestState(
                    listOf(pl.pw.data.Alphabet.letters[0].final, pl.pw.data.Alphabet.letters[1].final),
                    1,
                    2,
                    pl.pw.data.Alphabet.letters[1],
                ),
                onAnswer = {},
            )
        }
    }
}
