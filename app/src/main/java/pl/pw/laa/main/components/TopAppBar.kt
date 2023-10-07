package pl.pw.laa.main.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pl.pw.laa.navigation.NavigationItem
import pl.pw.laa.navigation.getCurrentDestination
import pl.pw.laa.navigation.getTopBarTitle
import pl.pw.laa.navigation.navigateAndPopUp
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior,
    topBarActions: List<NavigationItem>
) {
    val currentDestination = navController.getCurrentDestination()

    TopAppBar(
        title = {
            Text(
                text = stringResource(id = currentDestination.getTopBarTitle()),
                style = MaterialTheme.typography.titleMedium
            )
        },
        actions = {
            topBarActions.forEach { item ->
                IconButton(onClick = {
                    if (item.direction != currentDestination)
                        navController.navigateAndPopUp(item.direction)
                }) {
                    item.GetIcon(isSelected = item.direction == navController.getCurrentDestination())
                }
            }
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
            scrolledContainerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
            navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
            actionIconContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

private val topBarActionsForPreview = listOf(
    NavigationItem.Settings,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun LAATopNavBarPreview() {
    LearnArabicAlphabetTheme {
        val navController = rememberNavController()
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

        TopAppBar(navController, scrollBehavior, topBarActionsForPreview)
    }
}