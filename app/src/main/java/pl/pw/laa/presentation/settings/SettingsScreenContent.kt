package pl.pw.laa.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.componets.RowDivider
import pl.pw.laa.data.domain.BooleanPreference
import pl.pw.laa.data.domain.FormPreference
import pl.pw.laa.data.domain.IntPreference
import pl.pw.laa.presentation.settings.components.SettingsScreenContentPreferencesSwitchColumn
import pl.pw.laa.presentation.settings.components.SettingsScreenContentPreferencesChipGroup
import pl.pw.laa.presentation.settings.components.SettingsScreenContentExpandedNumberList

@Composable
fun SettingsScreenContent(
    state: SettingsState,
    paddingValues: PaddingValues,
    onEvent: (SettingsEvent) -> Unit,
) {
    val expanded by remember {
        mutableStateOf(false)
    }
    val answers = SettingsNumberListData(IntPreference.AnswersCount, state.answersCount)
    val checkBoxes = listOf(
        SettingsCheckBoxData(BooleanPreference.AreCheatsEnabled, state.areCheatsEnabled),
        SettingsCheckBoxData(BooleanPreference.AreTipsEnabled, state.areTipsEnabled)
    )
    val forms = listOf(
        SettingsChipData(FormPreference.IsInitial, state.isInitialTested),
        SettingsChipData(FormPreference.IsMedial, state.isMedialTested),
        SettingsChipData(FormPreference.IsFinal, state.isFinalTested),
        SettingsChipData(FormPreference.IsIsolated, state.isIsolatedTested)
    )
    Surface(modifier = Modifier.padding(paddingValues)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SettingsScreenContentExpandedNumberList(
                answers,
                expanded = expanded,
                onEvent,
            )
            RowDivider()
            SettingsScreenContentPreferencesSwitchColumn(
                checkBoxes,
                onEvent,
            )
            RowDivider()
            SettingsScreenContentPreferencesChipGroup(
                forms,
                onEvent,
            )
        }
    }
}

data class SettingsNumberListData(
    val preference: IntPreference,
    val value: Int,
)

data class SettingsCheckBoxData(
    val preference: BooleanPreference,
    val value: Boolean,
)

data class SettingsChipData(
    val preference: FormPreference,
    val value: Boolean,
)


//region Previews
@PreviewsPortrait
@PreviewsLandscape
@Composable
fun SettingsScreenContentPreview() {
    LearnArabicAlphabetSurfacePreview {
        SettingsScreenContent(
            SettingsState(),
            PaddingValues(),
        ) {}
    }
}

@PreviewsPortrait
@PreviewsLandscape
@Composable
fun SettingsScreenContentPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        SettingsScreenContent(
            SettingsState(),
            PaddingValues(),
        ) {}
    }
}

//endregion