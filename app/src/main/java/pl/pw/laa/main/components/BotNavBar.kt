package pl.pw.laa.main.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pl.pw.laa.navigation.NavigationItem
import pl.pw.laa.navigation.getCurrentDestination
import pl.pw.laa.navigation.navigateAndPopUp
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun BotNavBar(
    navController: NavHostController,
    bottomNavigationItems: List<NavigationItem>
) {
    val currentDestination = navController.getCurrentDestination()
    NavigationBar(
        modifier = Modifier.height(64.dp),
    ) {
        bottomNavigationItems.forEach { item ->
            NavigationBarItem(
                selected = item.direction == navController.getCurrentDestination(),
                onClick = {
                    if (item.direction != currentDestination)
                        navController.navigateAndPopUp(item.direction)
                },
                icon = {
                    item.GetIcon(isSelected = item.direction == navController.getCurrentDestination())
                },
                label = {
                    if (item.textId != null) Text(
                        text = stringResource(id = item.textId),
                        style = MaterialTheme.typography.labelSmall
                    )
                },
            )
        }
    }
}

private val bottomNavigationItemsForPreview = listOf(
    NavigationItem.Quiz,
    NavigationItem.Alphabet,
)

@Composable
@Preview(showBackground = true)
fun LAABotNavBarPreview() {
    LearnArabicAlphabetTheme {
        val navController = rememberNavController()
        BotNavBar(navController, bottomNavigationItemsForPreview)
    }
}