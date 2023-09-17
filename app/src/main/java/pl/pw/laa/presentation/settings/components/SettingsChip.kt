package pl.pw.laa.presentation.settings.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.pw.laa.data.domain.FormPreference
import pl.pw.laa.presentation.settings.SettingsEvent
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsChip(
    preferenceEnum: FormPreference,
    value: Boolean,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    FilterChip(
        modifier = modifier,
        selected = value,
        onClick = { SettingsChipOnEvent(preferenceEnum, !value , onEvent) },
        label = { Text(text = preferenceEnum.toString()) },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
        ),
    )
}

internal fun SettingsChipOnEvent(enum: FormPreference, newValue: Boolean, onEvent: (SettingsEvent) -> Unit) {
    Timber.d("Clicked at Settings Chip for key: ${enum}, current value:${newValue}, changing to: ${!newValue}")
    when (enum) {
        FormPreference.Initial -> onEvent(SettingsEvent.SetisInitialTested(newValue))
        FormPreference.Medial -> onEvent(SettingsEvent.SetisMedialTested(newValue))
        FormPreference.Final -> onEvent(SettingsEvent.SetisFinalTested(newValue))
        FormPreference.Isolated -> onEvent(SettingsEvent.SetisIsolatedTested(newValue))
    }
}
