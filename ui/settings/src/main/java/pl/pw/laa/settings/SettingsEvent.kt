package pl.pw.laa.settings

sealed interface SettingsEvent {
    data class SetAnswersCount(val answersCount: Int) : SettingsEvent
    data class SetAreCheatsOn(val areCheatsOn: Boolean) : SettingsEvent
    data class SetAreTipsOn(val areTipsOn: Boolean) : SettingsEvent
    data class SetisInitialTested(val isForm: Boolean) : SettingsEvent
    data class SetisMedialTested(val isForm: Boolean) : SettingsEvent
    data class SetisFinalTested(val isForm: Boolean) : SettingsEvent
    data class SetisIsolatedTested(val isForm: Boolean) : SettingsEvent
}
