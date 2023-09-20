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
import pl.pw.laa.data.domain.FormPreference
import pl.pw.laa.presentation.settings.SettingsEvent
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn( ExperimentalLayoutApi::class)
@Composable
fun SettingsChipGroup(
    enum1: FormPreference, val1: Boolean,
    enum2: FormPreference, val2: Boolean,
    enum3: FormPreference, val3: Boolean,
    enum4: FormPreference, val4: Boolean,
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
            SettingsChip(enum1, value = val1, onEvent = onEvent, modifier = mod)
            SettingsChip(enum2, value = val2, onEvent = onEvent, modifier = mod)
            SettingsChip(enum3, value = val3, onEvent = onEvent, modifier = mod)
            SettingsChip(enum4, value = val4, onEvent = onEvent, modifier = mod)
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
