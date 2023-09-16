package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.data.presistence.KeyNames
import pl.pw.laa.presentation.settings.SettingsEvent
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn( ExperimentalLayoutApi::class)
@Composable
fun SettingsChipGroup(
    key1: KeyNames, val1: Int,
    key2: KeyNames, val2: Int,
    key3: KeyNames, val3: Int,
    key4: KeyNames, val4: Int,
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
            SettingsChip(key = key1, value = val1, onEvent = onEvent, modifier = mod)
            SettingsChip(key = key2, value = val2, onEvent = onEvent, modifier = mod)
            SettingsChip(key = key3, value = val3, onEvent = onEvent, modifier = mod)
            SettingsChip(key = key4, value = val4, onEvent = onEvent, modifier = mod)
        }
    }
}


@Preview
@Composable
fun SettingsScreenPreview() {
    LearnArabicAlphabetTheme() {
//        SettingsChipGroup(
//            KeyNames.getDefaultKey(KeyNames.appConfigIsInitialTested),
//            KeyNames.getDefaultKey(KeyNames.appConfigIsMedialTested),
//            KeyNames.getDefaultKey(KeyNames.appConfigIsFinalTested),
//            AppConfigKey("Initial", "Initial", 0),
//            {},
//        )
    }
}
