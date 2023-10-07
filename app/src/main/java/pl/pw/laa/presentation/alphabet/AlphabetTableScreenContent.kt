package pl.pw.laa.presentation.alphabet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.componets.RowDivider
import pl.pw.laa.data.Alphabet
import pl.pw.laa.presentation.preview.LearnArabicAlphabetScreenContentPreview
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.alphabet.components.row.RowColumNames
import pl.pw.laa.presentation.alphabet.components.row.RowLetter

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
fun AlphabetTableScreenContentPreview() {
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