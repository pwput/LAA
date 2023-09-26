package pl.pw.laa.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavDestination
import com.ramcosta.composedestinations.spec.Direction
import pl.pw.laa.R
import pl.pw.laa.presentation.destinations.AlphabetTableScreenDestination
import pl.pw.laa.presentation.destinations.SettingsScreenDestination
import pl.pw.laa.quiz.destinations.QuestionScreenDestination

enum class NavigationItem(
    val direction: Direction,
    val textId: Int? = null,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    Quiz(
        direction = QuestionScreenDestination(),
        selectedIcon = Icons.Filled.Edit,
        textId = R.string.navigation_item_quiz_button_label,
        unselectedIcon = Icons.Outlined.Edit,
    ),
    Alphabet(
        direction = AlphabetTableScreenDestination,
        selectedIcon = Icons.Filled.List,
        textId = R.string.navigation_item_alphabet_button_label,
        unselectedIcon = Icons.Outlined.List,
    ),
    Settings(
        direction = SettingsScreenDestination,
        selectedIcon = Icons.Filled.Settings,
        textId = R.string.navigation_item_settings_button_label,
        unselectedIcon = Icons.Outlined.Settings,
    );

    @Composable
    fun GetIcon(isSelected: Boolean): Unit =
        if (isSelected)
            Icon(imageVector = this.selectedIcon, contentDescription = "selectedIcon")
            else Icon(imageVector = this.unselectedIcon, contentDescription = "unselectedIcon")
}

fun NavDestination.getTopBarTitle() =
    when (this) {
        NavigationItem.Quiz.direction -> R.string.navigation_item_quiz_top_bar_text
        NavigationItem.Alphabet.direction -> R.string.navigation_item_alphabet_top_bar_text
        NavigationItem.Settings.direction -> R.string.navigation_item_settings_top_bar_text
        else -> R.string.app_name
    }
