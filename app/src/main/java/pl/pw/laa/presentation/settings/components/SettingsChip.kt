package pl.pw.laa.presentation.settings.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.pw.data.model.AppConfigKey
import pl.pw.data.model.KeyNames.appConfigIsFinalTested
import pl.pw.data.model.KeyNames.appConfigIsInitialTested
import pl.pw.data.model.KeyNames.appConfigIsMedialTested
import pl.pw.laa.presentation.common.toBoolean
import pl.pw.laa.presentation.settings.SettingsEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsChip(
    key: AppConfigKey?,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    FilterChip(
        modifier = modifier,
        selected = key!!.value.toBoolean(),
        onClick = { onEvent(event(key)) },
        label = { Text(text = key.name) },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}

fun event(key: AppConfigKey) =
    when (key.key) {
        appConfigIsInitialTested -> SettingsEvent.SetisInitialTested(!key.value.toBoolean())
        appConfigIsMedialTested -> SettingsEvent.SetisMedialTested(!key.value.toBoolean())
        appConfigIsFinalTested -> SettingsEvent.SetisFinalTested(!key.value.toBoolean())
        else -> SettingsEvent.SetisIsolatedTested(!key.value.toBoolean())
    }
