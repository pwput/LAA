package pl.pw.laa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.Direction
import com.ramcosta.composedestinations.utils.currentDestinationAsState
import com.ramcosta.composedestinations.utils.startDestination

import timber.log.Timber

@Composable
fun NavHostController.getCurrentDestination(): DestinationSpec =
		this.currentDestinationAsState().value ?: NavGraphs.my.startDestination

fun NavHostController.navigateAndPopUp(direction: Direction) {
	Timber.i("Navigate to destination: '${direction::class.java.simpleName}', and pop up.")
	this.navigate(direction) {
		popUpTo(direction.route) {
			inclusive = true
		}
	}
}
