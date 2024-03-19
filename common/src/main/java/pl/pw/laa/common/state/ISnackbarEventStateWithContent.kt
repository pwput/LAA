package pl.pw.laa.common.state

import de.palm.composestateevents.StateEventWithContent

interface ISnackbarEventStateWithContent {
	val showSnackbarEvent: StateEventWithContent<Array<String>>
	//TODO change to array of strings
}