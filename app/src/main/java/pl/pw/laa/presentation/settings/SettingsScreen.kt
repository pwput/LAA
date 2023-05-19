package pl.pw.laa.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.data.model.DefaultKeys
import pl.pw.laa.data.model.KeyNames.appConfigAnswers
import pl.pw.laa.data.model.KeyNames.appConfigCheats
import pl.pw.laa.data.model.KeyNames.appConfigIsFinalTested
import pl.pw.laa.data.model.KeyNames.appConfigIsInitialTested
import pl.pw.laa.data.model.KeyNames.appConfigIsIsolatedTested
import pl.pw.laa.data.model.KeyNames.appConfigIsMedialTested
import pl.pw.laa.data.model.KeyNames.appConfigTips
import pl.pw.laa.presentation.settings.components.SettingsCheckBox
import pl.pw.laa.presentation.settings.components.SettingsChip
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn(ExperimentalLayoutApi::class)
@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val expanded by remember {
        mutableStateOf(false)
    }

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

    Column(
        modifier = Modifier
            .fillMaxSize().background(MaterialTheme.colorScheme.background)
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SettingsNumberList(
            key = numbers,
            expanded = expanded,
            onEvent = viewModel::onEvent,
            modifier = Modifier.weight(1f),
        )
        SettingsCheckBox(key = cheats, onEvent = viewModel::onEvent, modifier = Modifier.weight(1f))
        SettingsCheckBox(key = tips, onEvent = viewModel::onEvent, modifier = Modifier.weight(1f))

        FlowRow(Modifier.fillMaxWidth()) {
            val mod = Modifier.padding(4.dp)

            SettingsChip(key = isInitialTested, onEvent = viewModel::onEvent, modifier = mod)
            SettingsChip(key = isMedialTested, onEvent = viewModel::onEvent, modifier = mod)
            SettingsChip(key = isFinalTested, onEvent = viewModel::onEvent, modifier = mod)
            SettingsChip(key = isIsolatedTested, onEvent = viewModel::onEvent, modifier = mod)
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    LearnArabicAlphabetTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            SettingsScreen(navigator = EmptyDestinationsNavigator)
        }
    }
}
