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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.domain.IntPreference
import pl.pw.laa.presentation.settings.SettingsEvent
import pl.pw.laa.presentation.settings.SettingsNumberListData
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedNumberList(
    numberListData: SettingsNumberListData,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember {
        mutableStateOf(numberListData.isExpanded)
    }
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = numberListData.preference.labelId),
            modifier = modifier
                .weight(1f)
                .padding(start = 8.dp),
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
                    expandedNumberListonEvent(numberListData.preference,it.toInt(),onEvent)
                },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                numberListData.possibleNumbers.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item.toString()) },
                        onClick = {
                            Timber.d("Preference: '${numberListData.preference}', clicked at: '$item'")
                            expandedNumberListonEvent(numberListData.preference,item,onEvent)
                            expanded = false
                        },
                    )
                }
            }
        }
    }
}


internal fun expandedNumberListonEvent(
    preference: IntPreference,
    newValue: Int,
    onEvent: (SettingsEvent.SettingsEventInt) -> Unit
) {
    Timber.d("Clicked at Settings Chip for key: '$preference', current value: '$newValue', changing to: '${newValue}'")
    when (preference) {
        IntPreference.AnswersCount -> onEvent(SettingsEvent.SetAnswersCount(newValue))
        IntPreference.QuestionsCount -> onEvent(SettingsEvent.SetQuestionsCount(newValue))

    }
}

//region Previews
private val previewData = SettingsNumberListData(
    IntPreference.AnswersCount,
    4,
    listOf(2,4,6,8),
    false
)

@Preview
@Composable
fun ExpandedNumberListPreview() {
    LearnArabicAlphabetSurfacePreview() {
        ExpandedNumberList(
            previewData,
            { },
        )
    }
}

@Preview
@Composable
fun ExpandedNumberListPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        ExpandedNumberList(
            previewData,
            { },
        )
    }
}
//endregion