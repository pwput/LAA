package pl.pw.laa.presentation.settings.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pl.pw.laa.data.model.AppConfigKey
import pl.pw.laa.data.presistence.KeyNames
import pl.pw.laa.toBoolean
import pl.pw.laa.presentation.settings.SettingsEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsChip(
    key: KeyNames,
    value: Int,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    FilterChip(
        modifier = modifier,
        selected = value.toBoolean(),
        onClick = { onEvent(event(AppConfigKey(key.value,"",value))) },
        label = { Text(stringResource(id = key.resId)) },
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
        KeyNames.IsInitial.value -> SettingsEvent.SetisInitialTested(!key.value.toBoolean())
        KeyNames.IsMedial.value -> SettingsEvent.SetisMedialTested(!key.value.toBoolean())
        KeyNames.IsFinal.value -> SettingsEvent.SetisFinalTested(!key.value.toBoolean())
        else -> SettingsEvent.SetisIsolatedTested(!key.value.toBoolean())
    }
