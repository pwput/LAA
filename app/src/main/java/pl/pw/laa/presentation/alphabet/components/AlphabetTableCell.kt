package pl.pw.laa.presentation.alphabet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Form
import pl.pw.laa.presentation.common.AudioIcon
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

val padding = 8.dp
@Composable
fun AlphabetTableCellLetterForm(form: Form, modifier: Modifier) {
    Box(
        modifier = modifier,
    ) {
        Text(
            text = form.char.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.onBackground,
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
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colorScheme.onBackground,
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
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.BottomCenter),
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SingleFormPreview() {
    LearnArabicAlphabetTheme {
        AlphabetTableCellLetterForm(
            Alphabet.letters[1].final,
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
        )
    }
}