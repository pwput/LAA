package pl.pw.laa.presentation.settings

data class SettingsState(
    val numbers: Int,
    val cheats: Boolean,
    val tips: Boolean,
    val isInitialTested: Boolean,
    val isMedialTested: Boolean,
    val isFinalTested: Boolean,
    val isIsolatedTested: Boolean
)
