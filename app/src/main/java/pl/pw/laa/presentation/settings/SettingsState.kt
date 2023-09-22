package pl.pw.laa.presentation.settings

import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import pl.pw.laa.state.BaseState
import pl.pw.laa.state.UserPreferencesState
import pl.pw.laa.state.ISnackbarEventState

data class SettingsState(
    override var answersCount: Int = 8,
    override var areCheatsEnabled: Boolean = false,
    override var areTipsEnabled: Boolean = false,
    override var isInitialTested: Boolean = true,
    override var isMedialTested: Boolean = true,
    override var isFinalTested: Boolean = true,
    override var isIsolatedTested: Boolean = true,
    override val showSnackbarEvent: StateEvent = consumed
): BaseState(), ISnackbarEventState, UserPreferencesState{
    fun formCount(): Int {
        var count = 0
        if (isInitialTested) count++
        if (isMedialTested) count++
        if (isFinalTested) count++
        if (isIsolatedTested) count++
        return count
    }
}