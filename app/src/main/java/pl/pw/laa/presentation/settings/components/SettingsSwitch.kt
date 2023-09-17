package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pl.pw.laa.data.domain.BooleanPreference
import pl.pw.laa.toBoolean
import pl.pw.laa.presentation.settings.SettingsEvent
import timber.log.Timber

@Composable
fun SettingsCheckBox(
    preference: BooleanPreference,
    value: Int,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = preference.labelId),
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Switch(
            checked = value.toBoolean(),
            onCheckedChange = {
                SettingsCheckBoxOnEvent(preference, value.toBoolean(), it, onEvent)
            },
            modifier = Modifier.weight(1f),
        )
    }
}

internal fun SettingsCheckBoxOnEvent(
    preference: BooleanPreference,
    oldValue: Boolean,
    newValue: Boolean,
    onEvent: (SettingsEvent) -> Unit
) {
    Timber.d("Clicked at Settings Check Box for key: ${preference}, current value:${oldValue}, changing to: ${newValue}")
    when(preference) {
        BooleanPreference.AreCheatsEnabled -> onEvent(SettingsEvent.SetAreCheatsOn(newValue))
        BooleanPreference.AreTipsEnabled -> onEvent(SettingsEvent.SetAreTipsOn(newValue))
        else -> {}
    }

}
