package pl.pw.laa.presentation.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.domain.Form
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.quiz.components.AnswersButtonGroup
import pl.pw.laa.presentation.quiz.components.QuestionBox
import pl.pw.laa.presentation.quiz.components.QuizTopBar

@Composable
fun QuestionScreenContentPortrait(
    state: QuizState,
    onEvent: (QuizEvent) -> MediaPlayerResponse?,
    onAnswer: (Form) -> Unit,
    showIcon: Boolean,
) {
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
            QuestionBox(state, showIcon, onEvent, modifier = Modifier.padding(0.dp,32.dp,0.dp,0.dp))
            AnswersButtonGroup(state, onAnswer, modifier = Modifier)
        }
    }
}

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