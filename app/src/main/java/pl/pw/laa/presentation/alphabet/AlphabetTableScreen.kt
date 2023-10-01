package pl.pw.laa.presentation.alphabet


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import de.palm.composestateevents.EventEffect
import pl.pw.laa.R
import pl.pw.laa.componets.CustomSnackbarData
import pl.pw.laa.componets.showSnackbar

@Destination
@Composable
fun AlphabetTableScreen(
    navigator: DestinationsNavigator,
    padding: PaddingValues,
    snackbarHostState: SnackbarHostState,
    viewModel: AlphabetTableViewModel = hiltViewModel(),
    viewState: AlphabetTableState = viewModel.viewState.collectAsStateWithLifecycle().value

) {
    val context = LocalContext.current

    Surface(color = MaterialTheme.colorScheme.surface) {
        AlphabetTableScreenContent(viewModel::onEvent, padding)
    }
    EventEffect(
        event = viewState.showSnackbarEvent,
        onConsumed = viewModel::setShowMessageConsumed
    ) {
        snackbarHostState.showSnackbar(
            CustomSnackbarData(
                context.resources.getString(R.string.alphabet_table_screen_snackbar_text, it[0]),
                showIcon = true
            )

        )
    }
}
