package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.data.model.AppConfigKey
import pl.pw.data.model.DefaultKeys
import pl.pw.data.model.KeyNames
import pl.pw.laa.presentation.settings.SettingsEvent
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SettingsChipGroup(
    key1: AppConfigKey?,
    key2: AppConfigKey?,
    key3: AppConfigKey?,
    key4: AppConfigKey?,
    onEvent: (SettingsEvent) -> Unit,
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Choose forms",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        FlowRow(Modifier.fillMaxWidth()) {
            val mod = Modifier.padding(4.dp)
            SettingsChip(key = key1, onEvent = onEvent, modifier = mod)
            SettingsChip(key = key2, onEvent = onEvent, modifier = mod)
            SettingsChip(key = key3, onEvent = onEvent, modifier = mod)
            SettingsChip(key = key4, onEvent = onEvent, modifier = mod)
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    LearnArabicAlphabetTheme() {
        SettingsChipGroup(
            DefaultKeys.getDefaultKey(KeyNames.appConfigIsInitialTested),
            DefaultKeys.getDefaultKey(KeyNames.appConfigIsMedialTested),
            DefaultKeys.getDefaultKey(KeyNames.appConfigIsFinalTested),
            AppConfigKey("Initial", "Initial", 0),
            {},
        )
    }
}
