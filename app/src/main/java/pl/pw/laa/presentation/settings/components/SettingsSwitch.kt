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
import pl.pw.data.presistence.KeyNames
import pl.pw.laa.presentation.common.toBoolean
import pl.pw.laa.presentation.settings.SettingsEvent
import timber.log.Timber

@Composable
fun SettingsCheckBox(
    key: KeyNames,
    value : Int,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            stringResource(id = key.resId),
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Switch(
            checked = value.toBoolean(),
            onCheckedChange = {
                Timber.d("Clicked at Settings Check Box for key: ${key}, current value:${value?.toBoolean()}, changing to: $it")
                if ((key) == KeyNames.AreCheats) {
                    onEvent(SettingsEvent.SetAreCheatsOn(it))
                } else {
                    onEvent(SettingsEvent.SetAreTipsOn(it))
                }
            },
            modifier = Modifier.weight(1f),
        )
    }
}
