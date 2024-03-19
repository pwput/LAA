package pl.pw.laa.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.generated.NavGraphs
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint
import pl.pw.laa.common.ui.theme.LearnArabicAlphabetTheme
import pl.pw.laa.main.components.BotNavBar
import pl.pw.laa.main.components.CustomSnackBar
import pl.pw.laa.main.components.TopAppBar
import pl.pw.laa.navigation.NavigationItem
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

			MobileAds.initialize(this) {}
			RequestConfiguration.Builder()
					.setTestDeviceIds(listOf("703C5E35AA5BE999A86E0601C90C9194"))

			LearnArabicAlphabetTheme(darkTheme = isSystemInDarkTheme()) {
				Surface(
						Modifier.fillMaxSize(),
						color = MaterialTheme.colorScheme.background
				) {
					Scaffold(
							snackbarHost = {
								SnackbarHost(hostState = snackbarHostState) { snackbarData: SnackbarData ->
									CustomSnackBar(
											snackbarData.visuals.withDismissAction,
											snackbarData.visuals.message,
									)
								}
							},
							modifier = Modifier
									.nestedScroll(scrollBehavior.nestedScrollConnection),
							topBar = {
								TopAppBar(navController, scrollBehavior, topBarActions)
							},
							bottomBar = {
								BotNavBar(navController, bottomNavigationItems)
							}
					) { paddingValues ->
						DestinationsNavHost(
								navGraph = NavGraphs.my,
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
}
