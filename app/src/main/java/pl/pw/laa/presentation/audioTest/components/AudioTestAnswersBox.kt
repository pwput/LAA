package pl.pw.laa.presentation.audioTest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.model.Form
import pl.pw.laa.presentation.audioTest.AudioTestStateWithContent
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

val paddingValues = PaddingValues(8.dp, 0.dp)

@Composable
fun AnswersBox(
    state: AudioTestStateWithContent,
    onAnswer: (Form) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (!state.formsList.isNullOrEmpty() && state.rightAnswer != null) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min).background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(8.dp),
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
                state = AudioTestStateWithContent(
                    listOf(Alphabet.letters[0].final, Alphabet.letters[1].final),
                    1,
                    2,
                    Alphabet.letters[1],
                ),
                onAnswer = {},
            )
        }
    }
}
