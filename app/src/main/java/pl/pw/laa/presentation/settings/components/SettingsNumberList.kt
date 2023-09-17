package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import pl.pw.laa.data.domain.IPreferencesEnum
import pl.pw.laa.presentation.settings.SettingsEvent
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsNumberList(
    preferenceEnum: IPreferencesEnum,
    number: Int,
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
            text = stringResource(id = preferenceEnum.labelId),
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = modifier,
        ) {
            TextField(
                value = number.toString(),
                textStyle = MaterialTheme.typography.bodyMedium,
                onValueChange = {
                    Timber.d("Clicked at Settings Number List for prefernce: ${preferenceEnum}, current value:${number}, changing to: $it")
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
                        text = {
                            Text(
                                text = item.toString(),
                            )
                        },
                        onClick = {
                            Timber.d("Clicked at Settings Number List Item for prefernce: ${preferenceEnum}, clicked at: $item")
                            onEvent(SettingsEvent.SetAnswersCount(item))
                            expanded = false
                        },
                    )
                }
            }
        }
    }
}
