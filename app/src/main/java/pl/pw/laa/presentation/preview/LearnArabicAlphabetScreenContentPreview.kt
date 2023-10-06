package pl.pw.laa.presentation.preview

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import pl.pw.laa.main.components.BotNavBar
import pl.pw.laa.main.components.CustomSnackBar
import pl.pw.laa.main.components.TopAppBar
import pl.pw.laa.navigation.NavigationItem
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

private val bottomNavigationItems = listOf(
    NavigationItem.Quiz,
    NavigationItem.Alphabet,
)

private val topBarActions = listOf(
    NavigationItem.Settings,
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnArabicAlphabetScreenContentPreview(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    LearnArabicAlphabetTheme(darkTheme = darkTheme) {
        val navController = rememberNavController()
        navController.enableOnBackPressed(false)
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        val snackbarHostState = remember {
            SnackbarHostState()
        }
        Surface(color = MaterialTheme.colorScheme.background) {
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
            ) {
                Scaffold(modifier = Modifier.padding(it)) {
                    content()
                }
            }
        }
    }
}
