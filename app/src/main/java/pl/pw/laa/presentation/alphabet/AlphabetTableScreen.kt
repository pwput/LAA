package pl.pw.laa.presentation.alphabet


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AlphabetTableScreen(
    navigator: DestinationsNavigator,
    padding: PaddingValues,
    viewModel: AlphabetTableViewModel = hiltViewModel(),
) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        AlphabetTableScreenContent(viewModel::onEvent, viewModel.showIcon,padding)
    }
}
