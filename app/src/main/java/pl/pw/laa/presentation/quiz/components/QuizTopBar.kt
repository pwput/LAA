package pl.pw.laa.presentation.quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.presentation.quiz.QuizStateWithContent

@Composable
fun QuizTopBar(
    state: QuizStateWithContent,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(1f)
            .background(MaterialTheme.colorScheme.background)
            .wrapContentHeight(),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier.fillMaxWidth(1f)) {
            Text(text = "Mistakes: ${state.mistakes}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
            Text(text = "Score: ${state.score}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onBackground)
        }
    }
}

//region Previews
@Composable
@Preview
fun QuizTopBarPreview() {
    LearnArabicAlphabetSurfacePreview {
        QuizTopBar(state = QuizStateWithContent())
    }
}

@Composable
@Preview
fun QuizTopBarPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        QuizTopBar(state = QuizStateWithContent())
    }
}
//endregion