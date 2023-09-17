package pl.pw.laa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.Direction

import pl.pw.laa.presentation.NavGraphs
import pl.pw.laa.presentation.appCurrentDestinationAsState
import pl.pw.laa.presentation.destinations.Destination
import pl.pw.laa.presentation.startAppDestination
import timber.log.Timber


@Composable
fun NavHostController.getCurrentDestination(): Destination =
    this.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination

fun NavHostController.navigateAndPopUp(direction: Direction) {
    Timber.i("Navigate to destination: '${direction::class.java.simpleName}', and pop up.")
    this.navigate(direction){
        popUpTo(direction.route){
            inclusive = true
        }
    }
}
