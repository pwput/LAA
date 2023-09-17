package pl.pw.laa.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint
import pl.pw.laa.navigation.NavigationItem
import pl.pw.laa.navigation.getCurrentDestination
import pl.pw.laa.navigation.getTopBarTitle
import pl.pw.laa.navigation.navigateAndPopUp
import pl.pw.laa.presentation.NavGraphs
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity() {

    private val bottomNavigationItems = listOf(
        NavigationItem.Quiz,
        NavigationItem.Alphabet,
    )

    private val topBarActions = listOf(
        NavigationItem.Settings,
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        Timber.plant(Timber.DebugTree())
        setContent {
            val navController = rememberNavController()
            navController.enableOnBackPressed(false)
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

            val snackbarHostState = remember {
                SnackbarHostState()
            }

            LearnArabicAlphabetTheme(darkTheme = isSystemInDarkTheme()) {
                Surface(
                    Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        modifier = Modifier
                            .nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            TopBar(navController, scrollBehavior)
                        },
                        bottomBar = {
                            BotNavBar(navController)
                        }
                    ) { paddingValues ->
                        DestinationsNavHost(
                            navGraph = NavGraphs.root,
                            navController = navController,
                            dependenciesContainerBuilder = {
                                dependency(paddingValues)
                                dependency(snackbarHostState)
                            })
                    }
                }
            }
        }
    }

    @Composable
    fun BotNavBar(
        navController: NavHostController
    ) {
        val currentDestination = navController.getCurrentDestination()
        NavigationBar(
            modifier = Modifier.height(64.dp)
        ) {
            bottomNavigationItems.forEach { item ->
                BottomNavigationItem(
                    selected = item.direction == navController.getCurrentDestination(),
                    onClick = {
                        if (item.direction != currentDestination)
                            navController.navigateAndPopUp(item.direction)
                    },
                    icon = {
                        item.GetIcon(isSelected = item.direction == navController.getCurrentDestination())
                    },
                    label = {
                        if (!item.label.isNullOrEmpty()) Text(
                            text = item.label,
                            style = MaterialTheme.typography.labelSmall
                        )
                    },
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar(
        navController: NavHostController,
        scrollBehavior: TopAppBarScrollBehavior
    ) {
        val currentDestination = navController.getCurrentDestination()

        TopAppBar(
            title = {
                Text(
                    navController.getCurrentDestination().getTopBarTitle(),
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
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                scrolledContainerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
                titleContentColor = MaterialTheme.colorScheme.onBackground,
                actionIconContentColor = MaterialTheme.colorScheme.onBackground
            )
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview(showBackground = true)
    fun LAATopNavBarPreview() {
        LearnArabicAlphabetTheme {
            val navController = rememberNavController()
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

            TopBar(navController, scrollBehavior)
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun LAABotNavBarPreview() {
        LearnArabicAlphabetTheme {
            val navController = rememberNavController()

            BotNavBar(navController)
        }
    }
}
