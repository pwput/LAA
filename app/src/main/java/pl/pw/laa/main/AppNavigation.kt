package pl.pw.laa.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency

@OptIn(ExperimentalMaterialNavigationApi::class)
@ExperimentalAnimationApi
@Composable
internal fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    val navHostEngine = rememberAnimatedNavHostEngine(
            rootDefaultAnimations = RootNavGraphDefaultAnimations(
                    enterTransition = {
                        defaultEnterTransition(initialState, targetState)

                    },
                    exitTransition = {
                        defaultExitTransition(
                                initialState,
                                targetState
                        )
                    },
                    popEnterTransition = { defaultPopEnterTransition() },
                    popExitTransition = { defaultPopExitTransition() },
            )
    )

    DestinationsNavHost(
            engine = navHostEngine,
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = modifier,
            dependenciesContainerBuilder = {
                dependency(currentNavigator())
            }
    )
}
