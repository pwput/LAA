package pl.pw.laa.quiz.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.pw.laa.common.annotation.preview.PreviewsPortrait
import pl.pw.laa.common.componets.AdmobBanner
import pl.pw.laa.common.mediaplayer.MediaPlayerResponse
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.domain.Form
import pl.pw.laa.quiz.event.QuizEvent
import pl.pw.laa.quiz.presentation.components.AnswersButtonGroup
import pl.pw.laa.quiz.presentation.components.QuestionBox
import pl.pw.laa.quiz.presentation.components.QuizTopBar
import pl.pw.laa.quiz.state.QuizState

@Composable
fun QuestionScreenContentPortrait(
		state: QuizState,
		onEvent: (QuizEvent) -> MediaPlayerResponse?,
		onAnswer: (Form) -> Unit,
		showIcon: Boolean,
) {
	Box(modifier = Modifier
			.fillMaxSize()) {
		Column(
				modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
		) {
			QuizTopBar(state)
			Column(
					modifier = Modifier
							.fillMaxSize(),
					horizontalAlignment = Alignment.CenterHorizontally,
					verticalArrangement = Arrangement.SpaceEvenly,
			) {
				QuestionBox(state, showIcon, onEvent, modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 0.dp))
				AnswersButtonGroup(state, onAnswer, modifier = Modifier.padding(bottom = 38.dp))
			}
		}
		AdmobBanner(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 4.dp))
	}
}

//
//region Previews
@PreviewsPortrait
@Composable
fun QuestionScreenPortrait4Preview() {
	LearnArabicAlphabetSurfacePreview {
		QuestionScreenContentPortrait(
				mockedState4,
				{ null },
				{},
				false,
		)
	}
}

@PreviewsPortrait
@Composable
fun QuestionScreenPortrait8Preview() {
	LearnArabicAlphabetSurfacePreview {
		QuestionScreenContentPortrait(
				mockedState8,
				{ null },
				{},
				false,
		)
	}
}
//endregion