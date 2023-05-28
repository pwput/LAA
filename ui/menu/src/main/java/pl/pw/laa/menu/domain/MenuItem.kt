package pl.pw.laa.menu.domain

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.alphabettable.destinations.AlphabetTableScreenDestination
import pl.pw.laa.audioquiz.destinations.QuestionScreenDestination
import pl.pw.laa.menu.MenuNavigator
import pl.pw.laa.settings.destinations.SettingsScreenDestination

sealed class MenuItem(val name: String) {
    abstract fun navigateToDestination(navigator: MenuNavigator)
}

object AlphabetTable : MenuItem("Alphabet") {
    override fun navigateToDestination(navigator: MenuNavigator) {
       navigator.navigateToAlphabetTable()
    }
}

object Test : MenuItem("Test") {
    override fun navigateToDestination(navigator: MenuNavigator) {
        navigator.navigateToAlphabetTable()
    }
}

object Settings : MenuItem("Settings") {
    override fun navigateToDestination(navigator: MenuNavigator) {
        navigator.navigateToSettings()
    }
}


val menuItemsForPreview = listOf(Test, AlphabetTable, Settings)
