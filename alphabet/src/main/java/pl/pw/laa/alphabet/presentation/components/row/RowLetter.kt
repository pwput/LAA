package pl.pw.laa.alphabet.presentation.components.row

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.alphabet.event.AlphabetTableEvent
import pl.pw.laa.alphabet.presentation.components.cell.CellForm
import pl.pw.laa.alphabet.presentation.components.cell.CellRowName
import pl.pw.laa.common.mediaplayer.MediaPlayerResponse
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Letter

@Composable
fun RowLetter(
		letter: Letter,
		onRowClick: (AlphabetTableEvent) -> MediaPlayerResponse,
		modifier: Modifier = Modifier,
		formsModifier: Modifier = Modifier,
) {
	val context = LocalContext.current
	Row(
			modifier = modifier
					.fillMaxWidth()
					.height(IntrinsicSize.Max)
					.clickable(
							interactionSource = MutableInteractionSource(),
							indication = null,
					) {
						onRowClick(AlphabetTableEvent.PlayLetterAudio(context, letter))
					},
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceEvenly,
	) {
		val formModifier = formsModifier.weight(1f)
		CellRowName(name = letter.name, modifier = formModifier)
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
		RowLetter(Alphabet.letters[1], { MediaPlayerResponse.Error })

	}
}

@Preview
@Composable
fun RowLetterPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		RowLetter(Alphabet.letters[1], { MediaPlayerResponse.Error })

	}
}
//endregion
