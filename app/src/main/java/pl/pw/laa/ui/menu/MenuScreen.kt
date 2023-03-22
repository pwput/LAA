package pl.pw.laa.ui.menu

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@RootNavGraph(start = true)
@Destination
@Composable
fun MenuScreen(
    navigator: DestinationsNavigator,
    list: List<MenuItem> = listOf(Test(), AlphabetTable(), Vocalization(), Settings()),
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(64.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        list.forEach {
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
        val list = listOf(Test(), AlphabetTable())
        MenuScreen(list = list, navigator = EmptyDestinationsNavigator)
    }
}
