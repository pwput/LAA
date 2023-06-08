package pl.pw.laa.presentation.settings

import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import pl.pw.laa.state.BaseState
import pl.pw.laa.state.IAppConfigState
import pl.pw.laa.state.ISnackbarEventState

data class SettingsState(
    override var numberOfAnswers: Int = 8,
    override var areCheatsOn: Boolean = false,
    override var areTipsOn: Boolean = false,
    override var isInitialTested: Boolean = true,
    override var isMedialTested: Boolean = true,
    override var isFinalTested: Boolean = true,
    override var isIsolatedTested: Boolean = true,
    override val showSnackbarEvent: StateEvent = consumed
): BaseState(), ISnackbarEventState, IAppConfigState