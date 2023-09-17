package pl.pw.laa.presentation.settings

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import de.palm.composestateevents.EventEffect
import pl.pw.laa.R
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.componets.LoadingScreen
import pl.pw.laa.componets.Message
import pl.pw.laa.componets.RowDivider
import pl.pw.laa.componets.ShowSnackbar
import pl.pw.laa.data.model.AppConfigKey
import pl.pw.laa.data.presistence.KeyNames
import pl.pw.laa.toInt
import pl.pw.laa.presentation.settings.components.SettingsCheckBox
import pl.pw.laa.presentation.settings.components.SettingsChipGroup
import pl.pw.laa.presentation.settings.components.SettingsNumberList
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@SuppressLint( "UnusedMaterial3ScaffoldPaddingParameter")

@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val viewState: SettingsState by viewModel.viewState.collectAsStateWithLifecycle()

    val context = LocalContext.current

    if (viewModel.isLoading)
        LoadingScreen()
    else
        Settings(
            viewState,
            viewModel::onEvent,
        )
    EventEffect(
        event = viewState.showSnackbarEvent,
        onConsumed = viewModel::setShowMessageConsumed
    ) {
        snackbarHostState.ShowSnackbar(Message(context.getString(R.string.settings_snackbar_text)))
    }

}

@Composable
fun Settings(
    state: SettingsState,
    onEvent: (SettingsEvent) -> Unit,
) {
        val expanded by remember {
            mutableStateOf(false)
        }
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SettingsNumberList(
                key = AppConfigKey(
                    KeyNames.NumberOfAnswers.value,
                    context.getString(KeyNames.NumberOfAnswers.resId),
                    state.numberOfAnswers
                ),
                expanded = expanded,
                onEvent = onEvent,
                modifier = Modifier.weight(1f),
            )
            RowDivider()
            SettingsCheckBox(
                KeyNames.AreCheats,
                state.areCheatsOn.toInt(),
                onEvent = onEvent,
                modifier = Modifier.weight(1f)
            )
            SettingsCheckBox(
                KeyNames.AreTips,
                state.areTipsOn.toInt(),
                onEvent = onEvent,
                modifier = Modifier.weight(1f)
            )
            RowDivider()
            SettingsChipGroup(
                KeyNames.IsInitial, state.isInitialTested.toInt(),
                KeyNames.IsMedial, state.isMedialTested.toInt(),
                KeyNames.IsFinal, state.isFinalTested.toInt(),
                KeyNames.IsIsolated, state.isIsolatedTested.toInt(),
                onEvent,
            )
    }
}

@PreviewsLandscape
@PreviewsPortrait
@Composable
fun SettingsScreenPreview() {
    LearnArabicAlphabetTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Settings(
                SettingsState(),
            ) {}
        }
    }
}
