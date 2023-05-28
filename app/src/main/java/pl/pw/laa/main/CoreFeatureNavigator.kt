package pl.pw.laa.main

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigate

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.alphabettable.AlphabetTableNavigator
import pl.pw.laa.alphabettable.destinations.AlphabetTableScreenDestination
import pl.pw.laa.audioquiz.AudioTestNavigator
import pl.pw.laa.audioquiz.destinations.QuestionScreenDestination
import pl.pw.laa.menu.MenuNavigator
import pl.pw.laa.menu.destinations.MenuScreenDestination
import pl.pw.laa.settings.SettingsNavigator
import pl.pw.laa.settings.destinations.SettingsScreenDestination

class CoreFeatureNavigator(
    private val navController: NavController
) : AlphabetTableNavigator, AudioTestNavigator, SettingsNavigator, MenuNavigator {
    override fun navigateBack() {
        navController.navigate(MenuScreenDestination)
    }

    override fun navigateToQuiz() {
        navController.navigate(QuestionScreenDestination)

    }

    override fun navigateToAlphabetTable() {
        navController.navigate(AlphabetTableScreenDestination)

    }

    override fun navigateToSettings() {
        navController.navigate(SettingsScreenDestination)

    }
}