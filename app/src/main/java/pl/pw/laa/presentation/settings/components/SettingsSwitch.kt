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
import pl.pw.data.model.AppConfigKey
import pl.pw.data.model.KeyNames.appConfigCheats
import pl.pw.laa.presentation.common.toBoolean
import pl.pw.laa.presentation.settings.SettingsEvent
import timber.log.Timber

@Composable
fun SettingsCheckBox(
    key: AppConfigKey?,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
    text: String? = key?.key,
) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text ?: "null",
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        Switch(
            checked = key?.value?.toBoolean() ?: false,
            onCheckedChange = {
                Timber.d("Clicked at Settings Check Box for key: ${key?.key}, current value:${key?.value?.toBoolean()}, changing to: $it")
                if ((key?.key ?: "") == appConfigCheats) {
                    onEvent(SettingsEvent.SetAreCheatsOn(it))
                } else {
                    onEvent(SettingsEvent.SetAreTipsOn(it))
                }
            },
            modifier = Modifier.weight(1f),
        )
    }
}
