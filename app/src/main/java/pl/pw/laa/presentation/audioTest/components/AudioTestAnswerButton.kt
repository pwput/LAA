package pl.pw.laa.presentation.audioTest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Form
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun AnswerButton(
    form: Form,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cheats: Boolean = false
) {
    val borderColor = if (cheats) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.secondary
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
           //modifier = Modifier.padding(8.dp),
        )
    }
}

@Preview()
@Composable
fun AnswerButtonPreview() {
    LearnArabicAlphabetTheme() {
        AnswerButton(
            form = Alphabet.letters[0].final,
            modifier = Modifier.background(Color.Green).size(100.dp),
            onClick = {},
        )
    }
}
