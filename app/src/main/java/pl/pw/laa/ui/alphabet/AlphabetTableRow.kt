package pl.pw.laa.ui.alphabet

import android.media.MediaPlayer
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.R
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Letter
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun AlphabetTableRow(
    letter: Letter,
    modifier: Modifier = Modifier,
    formsModifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }
    val mediaPlayer = MediaPlayer.create(context, letter.vocalizationRaw)
    val onCompletionListener = MediaPlayer.OnCompletionListener {
        mediaPlayer.release()
        visible = false
    }

    Row(
        modifier = modifier.fillMaxWidth().height(IntrinsicSize.Max).clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
        ) {
            visible = true
            mediaPlayer.start()
            mediaPlayer.setOnCompletionListener(onCompletionListener)
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        val formModifier = formsModifier.weight(1f)
        AlphabetTableCellRowName(name = letter.name, modifier = formModifier, visible)
        AlphabetTableCellLetterForm(form = letter.isolated, modifier = formModifier)
        AlphabetTableCellLetterForm(form = letter.final, modifier = formModifier)
        AlphabetTableCellLetterForm(form = letter.medial, modifier = formModifier)
        AlphabetTableCellLetterForm(form = letter.initial, modifier = formModifier)
    }
}

@Composable
fun AlphabetTableColumNamesRow(modifier: Modifier = Modifier, tagsModifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_name,
            modifier = tagsModifier.weight(1f),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_isolated,
            modifier = tagsModifier.weight(1f),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_final,
            modifier = tagsModifier.weight(1f),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_medial,
            modifier = tagsModifier.weight(1f),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_initial,
            modifier = tagsModifier.weight(1f),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RowFormPreview() {
    LearnArabicAlphabetTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            AlphabetTableRow(letter = Alphabet.letters[1])
        }
    }
}
