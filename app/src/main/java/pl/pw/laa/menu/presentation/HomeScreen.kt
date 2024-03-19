package pl.pw.laa.menu.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.laa.menu.viewModel.HomeViewModel
import pl.pw.laa.navigation.MyGraph

@Destination<MyGraph>(start = true)
@Composable
fun HomeScreen(
		navigator: DestinationsNavigator,
		padding: PaddingValues,
		viewModel: HomeViewModel = hiltViewModel(),
) {
	val viewState = viewModel.viewState.collectAsStateWithLifecycle().value
	Surface(modifier = Modifier.padding(padding)) {
		HomeScreenContent(viewState)
	}
}


