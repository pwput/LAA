package pl.pw.laa.presentation.settings

import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed

data class SettingsState(
    val numbers: Int = 8,
    val cheats: Boolean =true,
    val tips: Boolean = true,
    val isInitialTested: Boolean = true,
    val isMedialTested: Boolean = true,
    val isFinalTested: Boolean = true,
    val isIsolatedTested: Boolean = true,
    val showMessageEvent: StateEvent = consumed
)