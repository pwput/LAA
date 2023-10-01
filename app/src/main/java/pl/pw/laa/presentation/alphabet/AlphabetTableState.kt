package pl.pw.laa.presentation.alphabet

import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import pl.pw.laa.state.BaseState
import pl.pw.laa.state.ISnackbarEventStateWithContent


data class AlphabetTableState(
    override val showSnackbarEvent: StateEventWithContent<Array<String>> = consumed(),
) : BaseState(), ISnackbarEventStateWithContent
