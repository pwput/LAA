package pl.pw.laa.presentation.alphabet.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.data.model.Letter
import pl.pw.laa.R
import pl.pw.laa.presentation.alphabet.AlphabetTableEvent
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun AlphabetTableRow(
    letter: Letter,
    onRowClick: (AlphabetTableEvent) -> pl.pw.laa.mediaplayer.MediaPlayerResponse,
    showIncon: Boolean,
    modifier: Modifier = Modifier,
    formsModifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }

    if (!showIncon) visible = false

    Row(
        modifier = modifier.fillMaxWidth().height(IntrinsicSize.Max)
            .background(MaterialTheme.colorScheme.background).clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
            ) {
                val resp = onRowClick(AlphabetTableEvent.PlayLetterAudio(context, letter))
                visible =
                    resp is pl.pw.laa.mediaplayer.MediaPlayerResponse.Success || resp is pl.pw.laa.mediaplayer.MediaPlayerResponse.AlreadyPlayingRequestedAudio
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        val formModifier = formsModifier.weight(1f).background(MaterialTheme.colorScheme.background)
        AlphabetTableCellRowName(name = letter.name, visible, modifier = formModifier)
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
            modifier = tagsModifier.weight(1f).background(MaterialTheme.colorScheme.background),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_isolated,
            modifier = tagsModifier.weight(1f).background(MaterialTheme.colorScheme.background),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_final,
            modifier = tagsModifier.weight(1f).background(MaterialTheme.colorScheme.background),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_medial,
            modifier = tagsModifier.weight(1f).background(MaterialTheme.colorScheme.background),
        )
        ColumnName(
            resourceId = R.string.alphabet_table_top_row_initial,
            modifier = tagsModifier.weight(1f).background(MaterialTheme.colorScheme.background),
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
            // AlphabetTableRow(letter = Alphabet.letters[1])
        }
    }
}
