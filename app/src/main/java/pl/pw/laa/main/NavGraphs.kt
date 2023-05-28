package pl.pw.laa.main

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import pl.pw.laa.alphabettable.destinations.AlphabetTableScreenDestination
import pl.pw.laa.audioquiz.destinations.QuestionScreenDestination
import pl.pw.laa.menu.destinations.MenuScreenDestination
import pl.pw.laa.settings.destinations.SettingsScreenDestination


object NavGraphs {

    val settings = object :NavGraphSpec {
        override val route = "settings"
        override val startRoute = SettingsScreenDestination
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            SettingsScreenDestination
        ).routedIn(this).associateBy { it.route }

    }
    val table = object :NavGraphSpec {
        override val route = "table"
        override val startRoute = AlphabetTableScreenDestination
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            AlphabetTableScreenDestination
        ).routedIn(this).associateBy { it.route }

    }
    val quiz = object :NavGraphSpec {
        override val route = "quiz"
        override val startRoute = QuestionScreenDestination
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            QuestionScreenDestination
        ).routedIn(this).associateBy { it.route }
    }
    val menu = object :NavGraphSpec {
        override val route = "menu"
        override val startRoute = MenuScreenDestination
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            MenuScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val root = object :NavGraphSpec{
        override val route = "root"
        override val startRoute = menu
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(settings, table, quiz,menu)

    }
}