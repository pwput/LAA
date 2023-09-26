package pl.pw.laa.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.Direction
import com.ramcosta.composedestinations.spec.NavGraphSpec

import timber.log.Timber


@Composable
fun NavHostController.getCurrentDestination(): NavDestination? =
    this.currentDestination

//fun NavHostController.navigateAndPopUp(navGraphSpec: NavGraphSpec) {
//    Timber.i("Navigate to destination: '${navGraphSpec::class.java.simpleName}', and pop up.")
//    this.navigate(navGraphSpec.route) {
//        launchSingleTop = true
//        restoreState = true
//        popUpTo(this.) {
//            inclusive = true
//        }
//    }

