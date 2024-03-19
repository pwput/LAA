package pl.pw.laa.quiz.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.pw.laa.common.annotation.preview.PreviewsLandscape
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
fun QuestionScreenContentLandscape(
		state: QuizState,
		onEvent: (QuizEvent) -> MediaPlayerResponse?,
		onAnswer: (Form) -> Unit,
		showIcon: Boolean,
) {
	Box(modifier = Modifier.fillMaxSize()) {
		Column(
				modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
				verticalArrangement = Arrangement.Center
		) {
			QuizTopBar(state)
			Row(
					modifier = Modifier.fillMaxSize(),
					horizontalArrangement = Arrangement.spacedBy(16.dp),
					verticalAlignment = Alignment.CenterVertically
			) {
				QuestionBox(
						state,
						showIcon,
						onEvent,
						modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight(1f)
				)
				AnswersButtonGroup(
						state,
						onAnswer,
						modifier = Modifier
                                .weight(0.5f)
                                .fillMaxSize(1f))
			}
		}
		AdmobBanner(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp))
	}
}

//region Previews
@PreviewsLandscape
@Composable
fun QuestionScreenLandscape8Preview() {
	LearnArabicAlphabetSurfacePreview {
		QuestionScreenContentLandscape(
				mockedState8,
				{ null },
				{},
				false,
		)
	}
}

@PreviewsLandscape
@Composable
fun QuestionScreenLandscape4Preview() {
	LearnArabicAlphabetSurfacePreview {
		QuestionScreenContentLandscape(
				mockedState4,
				{ null },
				{},
				false,
		)
	}
}
//endregion