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
import pl.pw.laa.data.model.AppConfigKey
import pl.pw.laa.data.model.DefaultKeys
import pl.pw.laa.data.model.KeyNames.appConfigAnswers
import pl.pw.laa.data.model.KeyNames.appConfigCheats
import pl.pw.laa.data.model.KeyNames.appConfigIsFinalTested
import pl.pw.laa.data.model.KeyNames.appConfigIsInitialTested
import pl.pw.laa.data.model.KeyNames.appConfigIsIsolatedTested
import pl.pw.laa.data.model.KeyNames.appConfigIsMedialTested
import pl.pw.laa.data.model.KeyNames.appConfigTips
import pl.pw.laa.presentation.alphabet.components.RowDivider
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
    val numbers by viewModel.appConfig.answers.collectAsState(
        initial = DefaultKeys.getDefaultKey(appConfigAnswers),
    )
    val cheats by viewModel.appConfig.cheats.collectAsState(
        initial = DefaultKeys.getDefaultKey(
            appConfigCheats,
        ),
    )
    val tips by viewModel.appConfig.tips.collectAsState(
        initial = DefaultKeys.getDefaultKey(
            appConfigTips,
        ),
    )
    val isInitialTested by viewModel.appConfig.initial.collectAsState(
        initial = DefaultKeys.getDefaultKey(appConfigIsInitialTested),
    )
    val isMedialTested by viewModel.appConfig.medial.collectAsState(
        initial = DefaultKeys.getDefaultKey(appConfigIsMedialTested),
    )
    val isFinalTested by viewModel.appConfig.final.collectAsState(
        initial = DefaultKeys.getDefaultKey(appConfigIsFinalTested),
    )
    val isIsolatedTested by viewModel.appConfig.isolated.collectAsState(
        initial = DefaultKeys.getDefaultKey(appConfigIsIsolatedTested),
    )

    Settings(
        numbers,
        cheats,
        tips,
        isInitialTested,
        isMedialTested,
        isFinalTested,
        isIsolatedTested,
        viewModel::onEvent,
    )
}

@Composable
fun Settings(
    numbers: AppConfigKey?,
    cheats: AppConfigKey?,
    tips: AppConfigKey?,
    isInitialTested: AppConfigKey?,
    isMedialTested: AppConfigKey?,
    isFinalTested: AppConfigKey?,
    isIsolatedTested: AppConfigKey?,
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
            key = numbers,
            expanded = expanded,
            onEvent = onEvent,
            modifier = Modifier.weight(1f),
        )
        RowDivider()
        SettingsCheckBox(key = cheats, onEvent = onEvent, modifier = Modifier.weight(1f))
        SettingsCheckBox(key = tips, onEvent = onEvent, modifier = Modifier.weight(1f))
        RowDivider()
        SettingsChipGroup(
            isInitialTested,
            isMedialTested,
            isFinalTested,
            isIsolatedTested,
            onEvent,
        )
    }
}

@DevicePreviewsLightPortrait
@DevicePreviewsDarkPortrait
@DevicePreviewsLightLandscape
@DevicePreviewsDarkLandscape
@Composable
fun SettingsScreenPreview() {
    LearnArabicAlphabetTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            Settings(
                DefaultKeys.getDefaultKey(appConfigAnswers),
                DefaultKeys.getDefaultKey(appConfigCheats),
                DefaultKeys.getDefaultKey(appConfigTips),
                DefaultKeys.getDefaultKey(appConfigIsInitialTested),
                DefaultKeys.getDefaultKey(appConfigIsMedialTested),
                DefaultKeys.getDefaultKey(appConfigIsFinalTested),
                DefaultKeys.getDefaultKey(appConfigIsIsolatedTested),
                {},
            )
        }
    }
}
