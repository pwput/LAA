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
import pl.pw.laa.ui.destinations.AlphabetTableDestination
import pl.pw.laa.ui.theme.MyApplicationTheme

@RootNavGraph(start = true)
@Destination
@Composable
fun MenuScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
    list: List<String> = listOf<String>("jeden", "dwa", "trzy"),
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(64.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        list.forEach {
            MenuButton(
                onClick = { navigator.navigate(AlphabetTableDestination()) },
                content = it,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MyApplicationTheme() {
        val list = listOf<String>("jeden", "dwa", "trzy")
        // MenuScreen(list = list)
    }
}
