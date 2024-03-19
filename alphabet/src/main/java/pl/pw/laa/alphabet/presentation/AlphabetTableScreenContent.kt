package pl.pw.laa.alphabet.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.pw.laa.alphabet.event.AlphabetTableEvent
import pl.pw.laa.alphabet.presentation.components.row.RowColumNames
import pl.pw.laa.alphabet.presentation.components.row.RowLetter
import pl.pw.laa.common.annotation.preview.PreviewsLandscape
import pl.pw.laa.common.annotation.preview.PreviewsPortrait
import pl.pw.laa.common.componets.RowDivider
import pl.pw.laa.common.mediaplayer.MediaPlayerResponse
import pl.pw.laa.common.preview.LearnArabicAlphabetScreenContentPreview
import pl.pw.laa.data.Alphabet

@Composable
fun AlphabetTableScreenContent(
		onEvent: (AlphabetTableEvent) -> MediaPlayerResponse,
		padding: PaddingValues
) {
	Column(
			Modifier
					.fillMaxSize()
					.padding(padding)
	) {
		RowColumNames()
		RowDivider()
		LazyColumn(Modifier.fillMaxSize()) {
			items(Alphabet.letters) { letter ->
				RowLetter(
						letter = letter,
						onEvent,
				)
				RowDivider()
			}
		}
	}
}

@PreviewsPortrait
@PreviewsLandscape
@Composable
fun AlphabetTableScreenPreview() {
	LearnArabicAlphabetScreenContentPreview {
		AlphabetTableScreenContent({ MediaPlayerResponse.Error }, PaddingValues(0.dp))
	}
}

@PreviewsPortrait
@PreviewsLandscape
@Composable
fun AlphabetTableScreenContentPreviewDark() {
	LearnArabicAlphabetScreenContentPreview(true) {
		AlphabetTableScreenContent({ MediaPlayerResponse.Error }, PaddingValues(0.dp))
	}
}