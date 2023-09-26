package pl.pw.laa.quiz.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.quiz.QuizState
import pl.pw.laa.quiz.R

@Composable
fun QuizTopBar(
    state: QuizState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val animatedProgress by animateFloatAsState(
            targetValue = (state.currentQuestionIndex)/state.questions.size.toFloat(),
            animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
            label = ""
        )
        LinearProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier.fillMaxWidth(1f),
            trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.fillMaxWidth(1f)
        ) {
            QuizTopBarText(
                text = stringResource(id = R.string.quiz_screen_top_bar_mistakes, state.mistakes),
                modifier = Modifier.weight(0.25f)
            )

            QuizTopBarText(
                text = stringResource(id = R.string.quiz_screen_top_bar_score, state.score),
                modifier = Modifier.weight(0.25f)

            )
        }
    }
}

@Composable
private fun QuizTopBarText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = modifier,
        textAlign = textAlign,
    )
}

//region Previews
@Composable
@Preview
fun QuizTopBarPreview() {
    LearnArabicAlphabetSurfacePreview {
        QuizTopBar(state = QuizState())
    }
}

@Composable
@Preview
fun QuizTopBarPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        QuizTopBar(state = QuizState())
    }
}
//endregion