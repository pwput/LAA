package pl.pw.laa.presentation.audioTest.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
    textColor: Color = Color.Black,
    onClick: () -> Unit,
    cheats: Boolean = false
) {
    val modifier = if (cheats) modifier.background(Color.Red) else modifier
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(2.dp, Color.Red, shape = RoundedCornerShape(25))
            .clip(RoundedCornerShape(25))
            .clickable { onClick() }
            .then(modifier),
    ) {
        Text(
            text = form.toString(),
            fontSize = 36.sp,
            color = textColor,
            modifier = Modifier.padding(8.dp),
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
