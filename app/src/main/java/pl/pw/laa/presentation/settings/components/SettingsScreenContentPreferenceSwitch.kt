package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.pw.laa.data.domain.BooleanPreference
import pl.pw.laa.presentation.settings.SettingsCheckBoxData
import pl.pw.laa.presentation.settings.SettingsEvent
import timber.log.Timber

@Composable
fun SettingsScreenContentPreferenceSwitch(
    checkBoxData: SettingsCheckBoxData,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = checkBoxData.preference.labelId),
            modifier = modifier.weight(1f).padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Switch(
            checked = checkBoxData.value,
            onCheckedChange = {
                settingsScreenContentPreferenceSwitchOnEvent(checkBoxData.preference, checkBoxData.value, it, onEvent)
            },
            modifier = modifier.weight(1f),
        )
    }
}

internal fun settingsScreenContentPreferenceSwitchOnEvent(
    preference: BooleanPreference,
    oldValue: Boolean,
    newValue: Boolean,
    onEvent: (SettingsEvent) -> Unit
) {
    Timber.d("BooleanPreference: '$preference', current value: '$oldValue', changing to: '$newValue'")
    when(preference) {
        BooleanPreference.AreCheatsEnabled -> onEvent(SettingsEvent.SetAreCheatsOn(newValue))
        BooleanPreference.AreTipsEnabled -> onEvent(SettingsEvent.SetAreTipsOn(newValue))
        else -> {}
    }
}
