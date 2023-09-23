package pl.pw.laa.presentation.quiz.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Form
import pl.pw.laa.presentation.quiz.QuizStateWithContent

private val buttonsSpacing = 12.dp

@Composable
fun QuizAnswersButtonGroup(
    state: QuizStateWithContent,
    onAnswer: (Form) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (!state.formsList.isNullOrEmpty() && state.rightAnswer != null) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalArrangement = Arrangement.spacedBy(buttonsSpacing),
        ) {
            for (i in 0 until state.formsList.size - 1 step 2) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(buttonsSpacing),
                ) {
                    AnswerButton(
                        form = state.formsList[i],
                        onClick = { onAnswer(state.formsList[i]) },
                        modifier = Modifier.weight(1f),
                        cheats = state.isRightAnswer(i) && state.areCheatsEnabled,
                    )
                    AnswerButton(
                        form = state.formsList[i + 1],
                        onClick = { onAnswer(state.formsList[i + 1]) },
                        modifier = Modifier.weight(1f),
                        cheats = state.isRightAnswer(i + 1) && state.areCheatsEnabled,
                    )
                }
            }
        }
    }
}

//region Previews
@Preview
@Composable
fun QuizAnswersButtonGroupPreview() {
    LearnArabicAlphabetSurfacePreview {
        QuizAnswersButtonGroup(
            state = QuizStateWithContent(
                listOf(Alphabet.letters[0].final, Alphabet.letters[1].final,
                    Alphabet.letters[2].final, Alphabet.letters[3].final,
                    Alphabet.letters[4].final, Alphabet.letters[5].final),
                1,
                2,
                Alphabet.letters[1],
            ),
            onAnswer = {},
        )
    }
}

@Preview
@Composable
fun QuizAnswersButtonGroupPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        QuizAnswersButtonGroup(
            state = QuizStateWithContent(
                listOf(Alphabet.letters[0].final, Alphabet.letters[1].final),
                1,
                2,
                Alphabet.letters[1],
            ),
            onAnswer = {},
        )
    }
}
//endregion