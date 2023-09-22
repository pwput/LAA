package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.pw.laa.presentation.settings.SettingsCheckBoxData
import pl.pw.laa.presentation.settings.SettingsEvent

@Composable
fun SettingsScreenContentPreferencesSwitchColumn(
    checkBoxDataList: List<SettingsCheckBoxData>,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column{
        checkBoxDataList.forEach { checkBoxData ->
            SettingsScreenContentPreferenceSwitch(
                checkBoxData,
                onEvent,
                modifier = modifier,
            )
        }
    }
}

