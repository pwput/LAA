package pl.pw.laa.presentation.alphabet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.componets.RowDivider
import pl.pw.laa.data.Alphabet
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.alphabet.components.row.RowColumNames
import pl.pw.laa.presentation.alphabet.components.row.RowLetter

@Composable
fun AlphabetTableScreenContent(
    onEvent: (AlphabetTableEvent) -> MediaPlayerResponse,
    showIcon: Boolean,
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
            itemsIndexed(items = Alphabet.letters) { index, letter ->
                RowLetter(
                    letter = letter,
                    onEvent,
                    showIcon,
                    Modifier.background(
                        if (index % 2 == 0)
                            Color.Transparent
                        else MaterialTheme.colorScheme.surfaceColorAtElevation((0.5).dp)
                    )
                )
            }
        }
    }
}

@PreviewsPortrait
@PreviewsLandscape
@Composable
fun AlphabetTableScreenContentPreview() {
    LearnArabicAlphabetSurfacePreview {
        AlphabetTableScreenContent({ MediaPlayerResponse.Error }, false, PaddingValues(0.dp))
    }
}

@PreviewsPortrait
@PreviewsLandscape
@Composable
fun AlphabetTableScreenContentPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        AlphabetTableScreenContent({ MediaPlayerResponse.Error }, false, PaddingValues(0.dp))
    }
}