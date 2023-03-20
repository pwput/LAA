package pl.pw.laa.ui.alphabet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.LetterForm
import pl.pw.laa.ui.theme.MyApplicationTheme

val padding = 8.dp
val fontSizeArabic = 32.sp
val fontSizeNormal = 16.sp

@Composable
fun SingleForm(form: LetterForm, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Text(text = form.uniC.toString(), fontSize = fontSizeArabic, modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun RowName(name: String, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Text(text = name, fontSize = fontSizeNormal, modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun ColumnName(name: String, modifier: Modifier) {
    Box(
        modifier = modifier.padding(PaddingValues(horizontal = 0.dp, vertical = padding))
    ) {
        Text(text = name, fontSize = fontSizeNormal, modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Preview(showBackground = true)
@Composable
fun SingleFormPreview() {
    MyApplicationTheme {
        SingleForm(Alphabet.letters[1].final, modifier = Modifier)
    }
}
