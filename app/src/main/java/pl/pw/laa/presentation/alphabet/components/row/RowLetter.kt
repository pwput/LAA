package pl.pw.laa.presentation.alphabet.components.row

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Letter
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.alphabet.AlphabetTableEvent
import pl.pw.laa.presentation.alphabet.components.cell.CellForm
import pl.pw.laa.presentation.alphabet.components.cell.CellRowName

@Composable
fun RowLetter(
    letter: Letter,
    onRowClick: (AlphabetTableEvent) -> MediaPlayerResponse,
    showIncon: Boolean,
    modifier: Modifier = Modifier,
    formsModifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }

    if (!showIncon) visible = false

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
            ) {
                val resp = onRowClick(AlphabetTableEvent.PlayLetterAudio(context, letter))
                visible =
                    resp is MediaPlayerResponse.Success || resp is MediaPlayerResponse.AlreadyPlayingRequestedAudio
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        val formModifier = formsModifier.weight(1f)
        CellRowName(name = letter.name, visible, modifier = formModifier)
        CellForm(form = letter.isolated, modifier = formModifier)
        CellForm(form = letter.final, modifier = formModifier)
        CellForm(form = letter.medial, modifier = formModifier)
        CellForm(form = letter.initial, modifier = formModifier)
    }
}

//region Previews
@Preview
@Composable
fun RowLetterPreview() {
    LearnArabicAlphabetSurfacePreview {
        RowLetter(Alphabet.letters[1], { MediaPlayerResponse.Error }, true)

    }
}

@Preview
@Composable
fun RowLetterPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        RowLetter(Alphabet.letters[1], { MediaPlayerResponse.Error }, false)

    }
}
//endregion
