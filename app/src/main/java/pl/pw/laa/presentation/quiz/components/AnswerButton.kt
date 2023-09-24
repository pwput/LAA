package pl.pw.laa.presentation.quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Form

@Composable
fun AnswerButton(
    form: Form,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cheats: Boolean = false
) {
    val borderColor = if (cheats)
        MaterialTheme.colorScheme.error
    else
        MaterialTheme.colorScheme.secondary

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(1.dp, borderColor, shape = RoundedCornerShape(25))
            .clip(RoundedCornerShape(25))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { onClick() }
            .then(modifier),
    ) {
        Text(
            text = form.toString(),
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    }
}


//region Previews
@Composable
@Preview()
fun AnswerButtonPreview() {
    LearnArabicAlphabetSurfacePreview {
        AnswerButton(
            form = Alphabet.letters[0].final,
            modifier = Modifier
                .size(80.dp),
            onClick = {},
        )
    }
}

@Composable
@Preview()
fun AnswerButtonPreviewDark() {
    LearnArabicAlphabetSurfacePreview (true) {
        AnswerButton(
            form = Alphabet.letters[0].final,
            modifier = Modifier
                .size(80.dp),
            onClick = {},
        )
    }
}


//endregion