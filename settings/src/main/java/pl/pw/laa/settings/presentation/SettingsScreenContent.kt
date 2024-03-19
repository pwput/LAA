package pl.pw.laa.settings.presentation

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
import pl.pw.laa.common.annotation.preview.PreviewsLandscape
import pl.pw.laa.common.annotation.preview.PreviewsPortrait
import pl.pw.laa.common.componets.RowDivider
import pl.pw.laa.common.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.domain.BooleanPreference
import pl.pw.laa.data.domain.FormPreference
import pl.pw.laa.data.domain.IntPreference
import pl.pw.laa.settings.event.SettingsEvent
import pl.pw.laa.settings.presentation.components.PreferencesChipGroup
import pl.pw.laa.settings.presentation.components.PreferencesExpandedNumberList
import pl.pw.laa.settings.presentation.components.PreferencesSwitchColumn
import pl.pw.laa.settings.state.SettingsState

@Composable
fun SettingsScreenContent(
		state: SettingsState,
		paddingValues: PaddingValues,
		onEvent: (SettingsEvent) -> Unit,
) {
	val isAnswersCountExpanded by remember {
		mutableStateOf(false)
	}
	val isQuestionsCountExpanded by remember {
		mutableStateOf(false)
	}
	val numberList = listOf(
			SettingsNumberListData(
					IntPreference.QuestionsCount,
					state.preferences.questionsCount,
					listOf(5, 10, 15, 20),
					isQuestionsCountExpanded
			),
			SettingsNumberListData(
					IntPreference.AnswersCount,
					state.preferences.answersCount,
					listOf(2, 4, 6, 8),
					isAnswersCountExpanded
			)
	)
	val checkBoxes = listOf(
			SettingsCheckBoxData(
					BooleanPreference.AreCheatsEnabled,
					state.preferences.areCheatsEnabled
			),
			SettingsCheckBoxData(BooleanPreference.AreTipsEnabled, state.preferences.areTipsEnabled)
	)
	val forms = listOf(
			SettingsChipData(FormPreference.IsInitial, state.preferences.isInitialTested),
			SettingsChipData(FormPreference.IsMedial, state.preferences.isMedialTested),
			SettingsChipData(FormPreference.IsFinal, state.preferences.isFinalTested),
			SettingsChipData(FormPreference.IsIsolated, state.preferences.isIsolatedTested)
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
			PreferencesExpandedNumberList(
					numberList,
					onEvent,
			)
			RowDivider()
			PreferencesSwitchColumn(
					checkBoxes,
					onEvent,
			)
			RowDivider()
			PreferencesChipGroup(
					forms,
					onEvent,
			)
		}
	}
}

data class SettingsNumberListData(
		val preference: IntPreference,
		val value: Int,
		val possibleNumbers: List<Int>,
		val isExpanded: Boolean
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