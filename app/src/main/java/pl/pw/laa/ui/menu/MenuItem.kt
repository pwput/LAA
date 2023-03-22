package pl.pw.laa.ui.menu

import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.ui.destinations.AlphabetTableDestination
import pl.pw.laa.ui.destinations.QuestionScreenDestination

sealed class MenuItem(val name: String) {
    abstract fun navigateToDestination(navigator: DestinationsNavigator)
}

class AlphabetTable : MenuItem("Alphabet") {
    override fun navigateToDestination(navigator: DestinationsNavigator) {
        navigator.navigate(AlphabetTableDestination())
    }
}

class Test : MenuItem("Test") {
    override fun navigateToDestination(navigator: DestinationsNavigator) {
        navigator.navigate(QuestionScreenDestination())
    }
}

class Vocalization : MenuItem("Vocalization"){
    override fun navigateToDestination(navigator: DestinationsNavigator) {
        //navigator.navigate(VocalizationS)
    }
}