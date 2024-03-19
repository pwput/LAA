package pl.pw.laa.settings.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.domain.FormPreference
import pl.pw.laa.settings.event.SettingsEvent

import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreferenceChip(
		preferenceEnum: FormPreference,
		value: Boolean,
		onEvent: (SettingsEvent.SettingsEventForm) -> Unit,
		modifier: Modifier = Modifier,
) {
	FilterChip(
			modifier = modifier,
			selected = value,
			onClick = { settingsScreenContentPreferenceChipOnEvent(preferenceEnum, !value, onEvent) },
			label = { Text(text = stringResource(id = preferenceEnum.labelId)) },
			colors = FilterChipDefaults.filterChipColors(
					containerColor = MaterialTheme.colorScheme.surfaceVariant,
					labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
					selectedContainerColor = MaterialTheme.colorScheme.primary,
					selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
			),
	)
}

private fun settingsScreenContentPreferenceChipOnEvent(
		preference: FormPreference,
		newValue: Boolean,
		onEvent: (SettingsEvent.SettingsEventForm) -> Unit
) {
	Timber.d("Clicked at Settings Chip for key: '$preference', current value: '$newValue', changing to: '${!newValue}'")
	when (preference) {
		FormPreference.IsInitial -> onEvent(SettingsEvent.SetIsInitialTested(newValue))
		FormPreference.IsMedial -> onEvent(SettingsEvent.SetIsMedialTested(newValue))
		FormPreference.IsFinal -> onEvent(SettingsEvent.SetIsFinalTested(newValue))
		FormPreference.IsIsolated -> onEvent(SettingsEvent.SetIsIsolatedTested(newValue))
	}
}

//region Previews
@Preview
@Composable
fun PreferenceChipPreview() {
	LearnArabicAlphabetSurfacePreview {
		PreferenceChip(
				preferenceEnum = FormPreference.IsInitial,
				value = true,
				onEvent = {},
		)
	}
}

@Preview
@Composable
fun PreferenceChipPreviewDark() {
	LearnArabicAlphabetSurfacePreview(true) {
		PreferenceChip(
				preferenceEnum = FormPreference.IsInitial,
				value = true,
				onEvent = {},
		)
	}
}
//endregion
