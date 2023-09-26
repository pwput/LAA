package pl.pw.laa.navigation

import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec
import pl.pw.laa.presentation.destinations.AlphabetTableScreenDestination
import pl.pw.laa.presentation.destinations.MenuScreenDestination
import pl.pw.laa.presentation.destinations.SettingsScreenDestination
import pl.pw.laa.presentation.destinations.VocalizationScreenDestination
import pl.pw.laa.quiz.destinations.QuestionScreenDestination

object NavGraphs {
        val root = object: NavGraphSpec {
            override val route ="root"

            override val startRoute = MenuScreenDestination routedIn this

            override val destinationsByRoute = listOf<DestinationSpec<*>>(
                AlphabetTableScreenDestination,
                MenuScreenDestination,
                SettingsScreenDestination,
                VocalizationScreenDestination,
                QuestionScreenDestination,
            ).routedIn(this)
                .associateBy { it.route }
        }
}
