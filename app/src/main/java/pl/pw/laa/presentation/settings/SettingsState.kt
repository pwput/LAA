package pl.pw.laa.presentation.settings

import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import pl.pw.laa.state.BaseState
import pl.pw.laa.state.UserPreferencesState
import pl.pw.laa.state.ISnackbarEventState

data class SettingsState(
    val preferences: UserPreferencesState = UserPreferencesState(),
    override val showSnackbarEvent: StateEvent = consumed
): BaseState(), ISnackbarEventState{
    fun formCount(): Int {
        var count = 0
        if (preferences.isInitialTested) count++
        if (preferences.isMedialTested) count++
        if (preferences.isFinalTested) count++
        if (preferences.isIsolatedTested) count++
        return count
    }
}