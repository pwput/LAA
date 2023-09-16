package pl.pw.laa.presentation.alphabet


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.componets.RowDivider
import pl.pw.laa.data.Alphabet
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.alphabet.components.AlphabetTableColumNamesRow
import pl.pw.laa.presentation.alphabet.components.AlphabetTableRow
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Destination
@Composable
fun AlphabetTableScreen(
    navigator: DestinationsNavigator,
    padding: PaddingValues,
    viewModel: AlphabetTableViewModel = hiltViewModel(),
) {
    AlphabetTable(viewModel::onEvent, viewModel.showIcon)
}

@Composable
fun AlphabetTable(
    onEvent: (AlphabetTableEvent) -> MediaPlayerResponse,
    showIcon: Boolean,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        AlphabetTableColumNamesRow()
        RowDivider()
        LazyColumn(Modifier.fillMaxSize()) {
            items(items = Alphabet.letters) {
                AlphabetTableRow(letter = it, onEvent, showIcon)
                RowDivider()
            }
        }
    }
}



@PreviewsLandscape
@PreviewsPortrait
@Composable
fun AlphabetTablePreview() {
    LearnArabicAlphabetTheme() {
        AlphabetTable({ MediaPlayerResponse.Error }, false)
    }
}
