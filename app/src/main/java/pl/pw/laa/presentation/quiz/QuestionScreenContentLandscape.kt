package pl.pw.laa.presentation.quiz

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
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.componets.AdmobBanner
import pl.pw.laa.data.domain.Form
import pl.pw.laa.presentation.preview.LearnArabicAlphabetScreenContentPreview
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.quiz.components.AnswersButtonGroup
import pl.pw.laa.presentation.quiz.components.QuestionBox
import pl.pw.laa.presentation.quiz.components.QuizTopBar

@Composable
fun QuestionScreenContentLandscape(
    state: QuizState,
    onEvent: (QuizEvent) -> MediaPlayerResponse?,
    onAnswer: (Form) -> Unit,
    showIcon: Boolean,
) {
    Box (modifier = Modifier.fillMaxSize()){
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
    AdmobBanner(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 8.dp))
    }
}

//region Previews
@PreviewsLandscape
@Composable
fun QuestionScreenLandscape8Preview() {
    LearnArabicAlphabetScreenContentPreview {
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
    LearnArabicAlphabetScreenContentPreview {
        QuestionScreenContentLandscape(
            mockedState4,
            { null },
            {},
            false,
        )
    }
}
//endregion