package pl.pw.laa.presentation.settings

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
import pl.pw.laa.data.model.AppConfigKey
import pl.pw.laa.data.model.appConfigAnswers
import pl.pw.laa.data.model.appConfigCheats
import pl.pw.laa.data.model.appConfigTips
import pl.pw.laa.presentation.settings.components.SettingsCheckBox
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Destination
@Composable
fun SettingsScreen(
    navigator: DestinationsNavigator,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val expanded by remember {
        mutableStateOf(false)
    }

    val numbers by viewModel.numberOfPossibleAnswers.collectAsState(initial = AppConfigKey(appConfigAnswers, 2))
    val cheats by viewModel.areCheatsOn.collectAsState(initial = AppConfigKey(appConfigCheats, 1))
    val tips by viewModel.areTipsOn.collectAsState(initial = AppConfigKey(appConfigTips, 1))

    Column(
        modifier = Modifier
            .fillMaxSize()
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
