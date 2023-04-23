package pl.pw.laa.presentation.alphabet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.data.Alphabet
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Destination
@Composable
fun AlphabetTable(navigator: DestinationsNavigator) {
    val viewModel = hiltViewModel<AlphabetTableViewModel>()

    Column(Modifier.fillMaxSize()) {
        AlphabetTableColumNamesRow()
        RowDivider()
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                RowDivider()
            }
            items(items = Alphabet.letters) {
                AlphabetTableRow(letter = it, viewModel::onEvent, viewModel.showIcon)
                RowDivider()
            }
        }
    }
}

@Composable
fun RowDivider() {
    Divider(color = Color.Gray, thickness = 1.dp)
}

@Preview
@Composable
fun AlphabetTablePreview() {
    LearnArabicAlphabetTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            AlphabetTable(navigator = EmptyDestinationsNavigator)
        }
    }
}
