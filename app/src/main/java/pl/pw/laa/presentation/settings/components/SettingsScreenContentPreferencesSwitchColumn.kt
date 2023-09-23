package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.data.domain.BooleanPreference
import pl.pw.laa.presentation.settings.SettingsCheckBoxData
import pl.pw.laa.presentation.settings.SettingsEvent

@Composable
fun SettingsScreenContentPreferencesSwitchColumn(
    checkBoxDataList: List<SettingsCheckBoxData>,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column{
        checkBoxDataList.forEach { checkBoxData ->
            SettingsScreenContentPreferenceSwitch(
                checkBoxData,
                onEvent,
                modifier = modifier,
            )
        }
    }
}

//region Previews
private val  data = listOf(
    SettingsCheckBoxData(
        BooleanPreference.AreCheatsEnabled,
        true
    ),
    SettingsCheckBoxData(
        BooleanPreference.AreTipsEnabled,
        false,
    )
)

@Preview
@Composable
fun SettingsScreenContentPreferencesSwitchColumnPreview() {
    LearnArabicAlphabetSurfacePreview {
        SettingsScreenContentPreferencesSwitchColumn(
            data,
            {}
        )
    }
}

@Preview
@Composable
fun SettingsScreenContentPreferencesSwitchColumnPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        SettingsScreenContentPreferencesSwitchColumn(
            data,
            {}
        )
    }
}
//endregion