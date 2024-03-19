package pl.pw.laa.common.preview

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.navigation.compose.rememberNavController
import pl.pw.laa.common.ui.theme.Dimensions
import pl.pw.laa.common.ui.theme.LearnArabicAlphabetTheme

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
					modifier = Modifier
							.nestedScroll(scrollBehavior.nestedScrollConnection),
					topBar = {
						Box(
								modifier = Modifier
										.height(Dimensions.topAppBarHeight)
										.fillMaxWidth()
										.background(MaterialTheme.colorScheme.error),
								contentAlignment = Alignment.Center
						)
						{
							Text(text = "TopAppBar", style = TextStyle(color = MaterialTheme.colorScheme.onError))
						}
					},
					bottomBar = {
						Box(
								modifier = Modifier
										.height(Dimensions.botNavBarHeight)
										.fillMaxWidth()
										.background(MaterialTheme.colorScheme.error),
								contentAlignment = Alignment.Center
						)
						{
							Text(text = "BotNav", style = TextStyle(color = MaterialTheme.colorScheme.onError))
						}
					}
			) {
				Scaffold(modifier = Modifier.padding(it)) {
					content()
				}
			}
		}
	}
}
