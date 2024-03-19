package pl.pw.laa.quiz.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.palm.composestateevents.consumed
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.common.state.UserPreferencesState
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Form
import pl.pw.laa.quiz.state.QuizState
import pl.pw.laa.quiz.state.SingleQuestion

private val buttonsSpacing = 8.dp

@Composable
fun AnswersButtonGroup(
		state: QuizState,
		onAnswer: (Form) -> Unit,
		modifier: Modifier = Modifier,
) {
	if (state.currentQuestion().forms.isNotEmpty() && state.currentQuestion().rightAnswer != null) {
		Column(
				modifier = modifier
						.fillMaxSize()
						.height(IntrinsicSize.Min),
				verticalArrangement = Arrangement.spacedBy(buttonsSpacing, Alignment.CenterVertically),
		) {
			for (i in 0 until state.currentQuestion().forms.size - 1 step 2) {
				Row(
						horizontalArrangement = Arrangement.spacedBy(buttonsSpacing),
				) {
					AnswerButton(
							form = state.currentQuestion().forms[i],
							onClick = { onAnswer(state.currentQuestion().forms[i]) },
							modifier = Modifier.weight(1f),
							cheats = state.currentQuestion().isRightAnswer(i) && state.preferences.areCheatsEnabled,
					)
					AnswerButton(
							form = state.currentQuestion().forms[i + 1],
							onClick = { onAnswer(state.currentQuestion().forms[i + 1]) },
							modifier = Modifier.weight(1f),
							cheats = state.currentQuestion().isRightAnswer(i + 1) && state.preferences.areCheatsEnabled,
					)
				}
			}
		}
	}
}

//region Previews
private val mockedState = QuizState(
		0,
		0,
		0,
		listOf(
				SingleQuestion(
						Alphabet.letters[0],
						listOf(
								Alphabet.letters[0].final,
								Alphabet.letters[1].final,
								Alphabet.letters[2].final,
								Alphabet.letters[3].final,
						),
				),
		),
		UserPreferencesState(),
		false,
		consumed(),
)

@Preview
@Composable
fun AnswersButtonGroupPreview() {
	LearnArabicAlphabetSurfacePreview {
		AnswersButtonGroup(
				state = mockedState,
				onAnswer = {},
		)
	}
}

@Preview
@Composable
fun AnswersButtonGroupPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		AnswersButtonGroup(
				state = mockedState,
				onAnswer = {},
		)
	}
}
//endregion