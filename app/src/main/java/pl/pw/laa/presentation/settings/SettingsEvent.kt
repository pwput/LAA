package pl.pw.laa.presentation.settings

sealed interface SettingsEvent {
    data class SetAnswersCount(val answersCount: Int) : SettingsEvent
    data class SetAreCheatsOn(val areCheatsOn: Boolean) : SettingsEvent
    data class SetAreTipsOn(val areTipsOn: Boolean) : SettingsEvent
}
