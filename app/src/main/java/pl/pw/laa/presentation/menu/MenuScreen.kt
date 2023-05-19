package pl.pw.laa.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.presentation.menu.components.MenuButton
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@RootNavGraph(start = true)
@Destination
@Composable
fun MenuScreen(
    navigator: DestinationsNavigator,
    viewModel: MenuViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
            .padding(64.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        viewModel.list.forEach {
            MenuButton(
                onClick = { it.navigateToDestination(navigator) },
                content = it.name,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    LearnArabicAlphabetTheme() {
        MenuScreen(navigator = EmptyDestinationsNavigator)
    }
}
