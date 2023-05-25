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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.data.model.AppConfigKey
import pl.pw.data.model.DefaultKeys
import pl.pw.data.model.KeyNames.appConfigAnswers
import pl.pw.data.model.KeyNames.appConfigCheats
import pl.pw.data.model.KeyNames.appConfigIsFinalTested
import pl.pw.data.model.KeyNames.appConfigIsInitialTested
import pl.pw.data.model.KeyNames.appConfigIsIsolatedTested
import pl.pw.data.model.KeyNames.appConfigIsMedialTested
import pl.pw.data.model.KeyNames.appConfigTips
import pl.pw.laa.presentation.common.componets.RowDivider
import pl.pw.laa.presentation.common.toInt
import pl.pw.laa.presentation.settings.components.SettingsCheckBox
import pl.pw.laa.presentation.settings.components.SettingsChipGroup
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn(ExperimentalLayoutApi::class)
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

    Column(
        modifier = Modifier
            .fillMaxSize().background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SettingsNumberList(
            key = AppConfigKey(appConfigAnswers, appConfigAnswers , state.numbers),
            expanded = expanded,
            onEvent = onEvent,
            modifier = Modifier.weight(1f),
        )
        RowDivider()
        SettingsCheckBox(AppConfigKey(appConfigCheats, appConfigCheats,state.cheats.toInt()), onEvent = onEvent, modifier = Modifier.weight(1f))
        SettingsCheckBox(AppConfigKey(appConfigTips, appConfigTips,state.tips.toInt()), onEvent = onEvent, modifier = Modifier.weight(1f))
        RowDivider()
        SettingsChipGroup(
            AppConfigKey(appConfigIsInitialTested, appConfigIsInitialTested,state.isInitialTested.toInt()),
            AppConfigKey(appConfigIsMedialTested, appConfigIsMedialTested,state.isMedialTested.toInt()),
            AppConfigKey(appConfigIsFinalTested, appConfigIsFinalTested,state.isFinalTested.toInt()),
            AppConfigKey(appConfigIsIsolatedTested, appConfigIsIsolatedTested,state.isIsolatedTested.toInt()),
            onEvent,
        )
    }
}

val state = SettingsState(8,
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
