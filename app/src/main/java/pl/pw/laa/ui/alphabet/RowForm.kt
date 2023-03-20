package pl.pw.laa.ui.alphabet

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Letter
import pl.pw.laa.ui.theme.MyApplicationTheme

@Composable
fun RowForm(letter: Letter, rowModifier: Modifier = Modifier, formsModifier: Modifier = Modifier) {
    Row(
        modifier = rowModifier.fillMaxWidth().height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val formModifier = formsModifier.weight(1f)
        RowName(name = letter.name, modifier = formModifier)
        SingleForm(form = letter.isolated, modifier = formModifier)
        SingleForm(form = letter.final, modifier = formModifier)
        SingleForm(form = letter.medial, modifier = formModifier)
        SingleForm(form = letter.initial, modifier = formModifier)
    }
}

@Composable
fun TopRow(rowModifier: Modifier = Modifier, tagsModifier: Modifier = Modifier) {
    Row(
        modifier = rowModifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ColumnName(name = Alphabet.forms[0], modifier = tagsModifier.weight(1f))
        ColumnName(name = Alphabet.forms[1], modifier = tagsModifier.weight(1f))
        ColumnName(name = Alphabet.forms[2], modifier = tagsModifier.weight(1f))
        ColumnName(name = Alphabet.forms[3], modifier = tagsModifier.weight(1f))
        ColumnName(name = Alphabet.forms[4], modifier = tagsModifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
fun RowFormPreview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            RowForm(letter = Alphabet.letters[1])
        }
    }
}
