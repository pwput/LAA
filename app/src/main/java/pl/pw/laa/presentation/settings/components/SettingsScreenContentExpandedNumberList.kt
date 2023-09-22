package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.pw.laa.presentation.settings.SettingsEvent
import pl.pw.laa.presentation.settings.SettingsNumberListData
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenContentExpandedNumberList(
    numberListData: SettingsNumberListData,
    expanded: Boolean,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
    possibleAnswers: List<Int> = listOf(2, 4, 6, 8),
) {
    var expanded by remember {
        mutableStateOf(expanded)
    }
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = numberListData.preference.labelId),
            modifier = modifier.weight(1f).padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = modifier.weight(1f),
        ) {
            TextField(
                value = numberListData.value.toString(),
                textStyle = MaterialTheme.typography.bodyMedium,
                onValueChange = {
                    Timber.d("Preference: '${numberListData.preference}', current value: '${numberListData.value}', changing to: '$it'")
                    onEvent(SettingsEvent.SetAnswersCount(it.toInt()))
                },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                possibleAnswers.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item.toString()) },
                        onClick = {
                            Timber.d("Preference: '${numberListData.preference}', clicked at: '$item'")
                            onEvent(SettingsEvent.SetAnswersCount(item))
                            expanded = false
                        },
                    )
                }
            }
        }
    }
}

//TODO: LOGS