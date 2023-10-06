package pl.pw.laa.presentation.settings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.pw.laa.data.domain.BooleanPreference
import pl.pw.laa.presentation.preview.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.presentation.settings.SettingsCheckBoxData
import pl.pw.laa.presentation.settings.SettingsEvent

@Composable
fun PreferencesSwitchColumn(
    checkBoxDataList: List<SettingsCheckBoxData>,
    onEvent: (SettingsEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column{
        checkBoxDataList.forEach { checkBoxData ->
            PreferenceSwitch(
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
fun PreferencesSwitchColumnPreview() {
    LearnArabicAlphabetSurfacePreview {
        PreferencesSwitchColumn(
            data,
            {}
        )
    }
}

@Preview
@Composable
fun PreferencesSwitchColumnPreviewDark() {
    LearnArabicAlphabetSurfacePreview(true) {
        PreferencesSwitchColumn(
            data,
            {}
        )
    }
}
//endregion