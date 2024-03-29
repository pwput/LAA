package pl.pw.laa.common.componets

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import de.palm.composestateevents.EventEffect
import de.palm.composestateevents.StateEvent

@Composable
fun SetupSnackbarHostState(
		snackbarHostState: SnackbarHostState,
		textId: Int,
		event: StateEvent,
		onConsumed: () -> Unit
) {
	val context = LocalContext.current

	EventEffect(
			event = event,
			onConsumed = onConsumed
	) {
		snackbarHostState.showSnackbar(CustomSnackbarData(context.getString(textId)))
	}
}