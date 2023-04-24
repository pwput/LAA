package pl.pw.laa.presentation.alphabet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Form
import pl.pw.laa.presentation.common.AudioIcon
import pl.pw.laa.ui.theme.Lateef
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

val padding = 8.dp
val fontSizeArabic = 48.sp
val fontSizeNormal = 16.sp

@Composable
fun AlphabetTableCellLetterForm(form: Form, modifier: Modifier) {
    Box(
        modifier = modifier,
    ) {
        androidx.compose.material.Text(
            text = form.char.toString(),
            fontFamily = Lateef,
            fontSize = fontSizeArabic,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}

@Composable
fun AlphabetTableCellRowName(
    name: String,
    modifier: Modifier,
    isAudioIconVisible: Boolean = false,
) {
    Box(
        modifier = modifier,
    ) {
        Text(
            text = name,
            fontSize = fontSizeNormal,
            modifier = Modifier.align(Alignment.Center),
        )
        AudioIcon(modifier = Modifier, visible = isAudioIconVisible)
    }
}

@Composable
fun ColumnName(resourceId: Int, modifier: Modifier) {
    Box(
        modifier = modifier.padding(PaddingValues(horizontal = 0.dp, vertical = padding)),
    ) {
        Text(
            stringResource(id = resourceId),
            fontSize = fontSizeNormal,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SingleFormPreview() {
    LearnArabicAlphabetTheme {
        AlphabetTableCellLetterForm(Alphabet.letters[1].final, modifier = Modifier)
    }
}
