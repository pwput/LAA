package pl.pw.laa.presentation.settings

sealed interface  SettingsEvent {
    val value: Any

    interface SettingsEventInt : SettingsEvent {
        override val value: Int
    }
    interface SettingsEventBoolean : SettingsEvent {
        override val value: Boolean
    }
    interface SettingsEventForm : SettingsEventBoolean

    data class SetQuestionsCount(override val value: Int) : SettingsEventInt
    data class SetAnswersCount(override val value: Int) : SettingsEventInt
    data class SetAreCheatsOn(override val value: Boolean) : SettingsEventBoolean
    data class SetAreTipsOn(override val value: Boolean) : SettingsEventBoolean
    data class SetIsInitialTested(override val value: Boolean) : SettingsEventForm
    data class SetIsMedialTested(override val value: Boolean) : SettingsEventForm
    data class SetIsFinalTested(override val value: Boolean) : SettingsEventForm
    data class SetIsIsolatedTested(override val value: Boolean) : SettingsEventForm
}
