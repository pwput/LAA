package pl.pw.laa.presentation.menu

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.presentation.destinations.AlphabetTableDestination
import pl.pw.laa.presentation.destinations.QuestionScreenDestination
import pl.pw.laa.presentation.destinations.SettingsScreenDestination
import pl.pw.laa.presentation.destinations.VocalizationScreenDestination

sealed class MenuItem(val name: String) {
    abstract fun navigateToDestination(navigator: DestinationsNavigator)
}

object AlphabetTable : MenuItem("Alphabet") {
    override fun navigateToDestination(navigator: DestinationsNavigator) {
        navigator.navigate(AlphabetTableDestination())
    }
}

object Test : MenuItem("Test") {
    override fun navigateToDestination(navigator: DestinationsNavigator) {
        navigator.navigate(QuestionScreenDestination())
    }
}

object Settings : MenuItem("Settings") {
    override fun navigateToDestination(navigator: DestinationsNavigator) {
        navigator.navigate(SettingsScreenDestination())
    }
}

object Vocalization : MenuItem("Vocalization") {
    override fun navigateToDestination(navigator: DestinationsNavigator) {
        navigator.navigate(VocalizationScreenDestination())
    }
}
