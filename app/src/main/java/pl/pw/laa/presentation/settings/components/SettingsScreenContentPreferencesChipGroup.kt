package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.pw.laa.R
import pl.pw.laa.presentation.settings.SettingsChipData
import pl.pw.laa.presentation.settings.SettingsEvent

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SettingsScreenContentPreferencesChipGroup(
    chipDataList: List<SettingsChipData>,
    onEvent: (SettingsEvent) -> Unit
) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.settings_screen_content_preferences_chip_group_title),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )
        FlowRow(
            modifier = Modifier.align(CenterHorizontally),
            verticalArrangement = Arrangement.spacedBy((-4).dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            chipDataList.forEach { chipData ->
                SettingsScreenContentPreferenceChip(
                    chipData.preference,
                    chipData.value,
                    onEvent,
                    modifier = Modifier.padding(0.dp)
                )
            }
        }
    }
}
