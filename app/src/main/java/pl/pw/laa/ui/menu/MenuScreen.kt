package pl.pw.laa.ui.menu

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.ui.theme.MyApplicationTheme

@Composable
fun menuScreen(modifier: Modifier = Modifier, list: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize().padding(64.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        list.forEach {
            MenuButton(onClick = {}, content = it, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    MyApplicationTheme() {
        val list = listOf<String>("jeden", "dwa", "trzy")
        menuScreen(list = list)
    }
}
