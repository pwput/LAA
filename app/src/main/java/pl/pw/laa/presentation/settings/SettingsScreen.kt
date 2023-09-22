package pl.pw.laa.presentation.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.R
import pl.pw.laa.componets.IfNotLoading
import pl.pw.laa.componets.SetupSnackbarHostState

@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState,
    viewModel: SettingsViewModel = hiltViewModel(),
    viewState: SettingsState = viewModel.viewState.collectAsStateWithLifecycle().value
) {
    IfNotLoading(isLoading = viewModel.isLoading()) {
        SettingsScreenContent(
            viewState,
            paddingValues,
            viewModel::onEvent
        )
    }
    SetupSnackbarHostState(
        snackbarHostState,
        R.string.settings_screen_snackbar_text,
        viewState.showSnackbarEvent,
        viewModel::setShowMessageConsumed
    )
}
