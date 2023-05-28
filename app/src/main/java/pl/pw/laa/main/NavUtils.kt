package pl.pw.laa.main

import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder



 fun DependenciesContainerBuilder<*>.currentNavigator(): CoreFeatureNavigator {
    return CoreFeatureNavigator(navController = navController)
}