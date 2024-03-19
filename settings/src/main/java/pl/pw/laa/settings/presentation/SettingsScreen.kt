package pl.pw.laa.settings.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.common.componets.IfNotLoading
import pl.pw.laa.common.componets.SetupSnackbarHostState
import pl.pw.laa.settings.R
import pl.pw.laa.settings.state.SettingsState
import pl.pw.laa.settings.viewModel.SettingsViewModel

@Destination<RootGraph>
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
