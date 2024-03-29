package pl.pw.laa.quiz.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.palm.composestateevents.consumed
import pl.pw.laa.common.componets.AudioIcon
import pl.pw.laa.common.componets.CardBox
import pl.pw.laa.common.mediaplayer.MediaPlayerResponse
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.common.state.UserPreferencesState
import pl.pw.laa.data.Alphabet
import pl.pw.laa.quiz.event.QuizEvent
import pl.pw.laa.quiz.state.QuizState
import pl.pw.laa.quiz.state.SingleQuestion

@Composable
fun QuestionBox(
		viewState: QuizState,
		showIcon: Boolean,
		onEvent: (QuizEvent) -> MediaPlayerResponse?,
		modifier: Modifier = Modifier,
) {
	var firstAudioPlay by remember { mutableStateOf(true) }
	var previousAudioPlayLetter by remember { mutableStateOf(viewState.currentQuestion().rightAnswer) }

	val context = LocalContext.current

	var visible by remember { mutableStateOf(false) }

	if (!showIcon) visible = false

	if (firstAudioPlay || previousAudioPlayLetter != viewState.currentQuestion().rightAnswer) {
		viewState.currentQuestion().rightAnswer?.let {
			onEvent(QuizEvent.ReplayAudio(context, viewState.currentQuestion().rightAnswer!!))
		}
		firstAudioPlay = false
		previousAudioPlayLetter = viewState.currentQuestion().rightAnswer
	}
	CardBox(
			shape = RoundedCornerShape(5),
			border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
			colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
			cardModifier = modifier
					.fillMaxWidth(1f)
					.aspectRatio(2f, false)
					.clickable(
							interactionSource = MutableInteractionSource(),
							indication = null,
					) {
						viewState.currentQuestion().rightAnswer?.let {
							val resp = onEvent(QuizEvent.ReplayAudio(context, viewState.currentQuestion().rightAnswer!!))
							visible =
									resp is MediaPlayerResponse.Success || resp is MediaPlayerResponse.AlreadyPlayingRequestedAudio
						}
					},
	) {
		Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center,
				modifier = Modifier.fillMaxSize(),
		) {
			Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.BottomCenter) {
				Text(
						text = if (viewState.preferences.areCheatsEnabled)
							viewState.currentQuestion().rightAnswer.toString()
						else
							viewState.currentQuestion().rightAnswer?.name ?: "null",
						style = MaterialTheme.typography.displayLarge,
						color = MaterialTheme.colorScheme.onSecondaryContainer,
				)
			}
			Box(
					modifier = Modifier
							.weight(1f)
							.fillMaxSize(),
					contentAlignment = Alignment.Center
			) {
				AudioIcon(visible)
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
						listOf(Alphabet.letters[0].final, Alphabet.letters[1].final),
				),
		),
		UserPreferencesState(),
		false,
		consumed(),
)

@Preview
@Composable
fun QuestionBoxPreview() {
	LearnArabicAlphabetSurfacePreview {
		QuestionBox(
				mockedState,
				true,
				{ null },
		)
	}
}

@Preview
@Composable
fun QuestionBoxCheatsPreview() {
	LearnArabicAlphabetSurfacePreview {
		QuestionBox(
				mockedState,
				false,
				{ null },
		)
	}
}

@Preview
@Composable
fun QuestionBoxPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		QuestionBox(
				mockedState,
				true,
				{ null },
		)
	}
}

@Preview
@Composable
fun QuestionBoxCheatsPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		QuestionBox(
				mockedState,
				false,
				{ null },
		)
	}
}
//endregion
