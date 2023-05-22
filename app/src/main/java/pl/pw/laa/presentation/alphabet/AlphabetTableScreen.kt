package pl.pw.laa.presentation.alphabet

import DevicePreviewsDarkLandscape
import DevicePreviewsDarkPortrait
import DevicePreviewsLightLandscape
import DevicePreviewsLightPortrait
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.data.Alphabet
import pl.pw.laa.presentation.alphabet.components.AlphabetTableColumNamesRow
import pl.pw.laa.presentation.alphabet.components.AlphabetTableRow
import pl.pw.laa.presentation.mediaplayer.MediaPlayerResponse
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Destination
@Composable
fun AlphabetTableScreen(
    navigator: DestinationsNavigator,
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

@Composable
fun RowDivider() {
    Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.dp)
}

@DevicePreviewsLightPortrait
@DevicePreviewsDarkPortrait
@DevicePreviewsLightLandscape
@DevicePreviewsDarkLandscape
@Composable
fun AlphabetTablePreview() {
    LearnArabicAlphabetTheme() {
        AlphabetTable({ MediaPlayerResponse.Error }, false)
    }
}
