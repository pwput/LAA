package pl.pw.laa.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.Direction
import pl.pw.laa.presentation.destinations.AlphabetTableScreenDestination
import pl.pw.laa.presentation.destinations.QuestionScreenDestination
import pl.pw.laa.presentation.destinations.SettingsScreenDestination

enum class NavigationItem(
    val direction: Direction,
    val label: String? = null,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    Quiz(
        direction = QuestionScreenDestination(),
        selectedIcon = Icons.Filled.Edit,
        label = "Test",
        unselectedIcon = Icons.Outlined.Edit,
    ),
    Alphabet(
        direction = AlphabetTableScreenDestination,
        selectedIcon = Icons.Filled.List,
        label = "Alphabet",
        unselectedIcon = Icons.Outlined.List,
    ),
    Settings(
        direction = SettingsScreenDestination,
        selectedIcon = Icons.Filled.Settings,
        label = "Alphabet",
        unselectedIcon = Icons.Outlined.Settings,
    );


    @Composable
    fun getIcon(isSelected: Boolean): Unit =
        if (isSelected)
            Icon(imageVector = this.selectedIcon, contentDescription = "selectedIcon")
            else Icon(imageVector = this.unselectedIcon, contentDescription = "unselectedIcon")
}
