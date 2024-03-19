package pl.pw.laa.alphabet.state

import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import pl.pw.laa.common.state.BaseState
import pl.pw.laa.common.state.ISnackbarEventStateWithContent

data class AlphabetTableState(
		override val showSnackbarEvent: StateEventWithContent<Array<String>> = consumed(),
) : BaseState(), ISnackbarEventStateWithContent
