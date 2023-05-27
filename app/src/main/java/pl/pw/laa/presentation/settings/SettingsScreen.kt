package pl.pw.laa.presentation.settings

import DevicePreviewsDarkLandscape
import DevicePreviewsDarkPortrait
import DevicePreviewsLightLandscape
import DevicePreviewsLightPortrait
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.data.model.AppConfigKey
import pl.pw.data.presistence.KeyNames
import pl.pw.laa.presentation.common.componets.RowDivider
import pl.pw.laa.presentation.common.toInt
import pl.pw.laa.presentation.settings.components.SettingsCheckBox
import pl.pw.laa.presentation.settings.components.SettingsChipGroup
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    Settings(
        viewModel.state,
        viewModel::onEvent,
    )
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
                state.numbers
            ),
            expanded = expanded,
            onEvent = onEvent,
            modifier = Modifier.weight(1f),
        )
        RowDivider()
        SettingsCheckBox(
            KeyNames.AreCheats,
            state.cheats.toInt(),
            onEvent = onEvent,
            modifier = Modifier.weight(1f)
        )
        SettingsCheckBox(
            KeyNames.AreTips,
            state.tips.toInt(),
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

val state = SettingsState(
    8,
    cheats = true,
    tips = true,
    isInitialTested = true,
    isMedialTested = true,
    isFinalTested = true,
    isIsolatedTested = true
)

@DevicePreviewsLightPortrait
@DevicePreviewsDarkPortrait
@DevicePreviewsLightLandscape
@DevicePreviewsDarkLandscape
@Composable
fun SettingsScreenPreview() {
    LearnArabicAlphabetTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Settings(
                state,
                {},
            )
        }
    }
}
