package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.domain.IntPreference
import pl.pw.laa.presentation.settings.SettingsEvent
import pl.pw.laa.presentation.settings.SettingsNumberListData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PreferencesExpandedNumberList(
    expandedNumberDataList: List<SettingsNumberListData>,
    onEvent: (SettingsEvent) -> Unit
) {
    Column(
        horizontalAlignment = CenterHorizontally,
    ) {
        FlowColumn(
            modifier = Modifier.align(CenterHorizontally),
        ) {
            expandedNumberDataList.forEach { data ->
                ExpandedNumberList(
                    data,
                    onEvent,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
    }
}


//region Previews

private val dataForPreview = listOf(
    SettingsNumberListData(
        IntPreference.QuestionsCount,
        5,
        listOf(5, 10, 15, 20),
        false
    ),
    SettingsNumberListData(
        IntPreference.AnswersCount,
        4,
        listOf(2, 4, 6, 8),
        true
    )
)
@Preview
@Composable
fun PreferencesExpandedNumberListPreview() {
    LearnArabicAlphabetSurfacePreview {
        PreferencesExpandedNumberList(
            dataForPreview,
        ) {}
    }
}
@Preview
@Composable
fun PreferencesExpandedNumberListPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        PreferencesExpandedNumberList(
            dataForPreview,
        ) {}
    }
}
//endregion