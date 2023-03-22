package pl.pw.laa.ui.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun SettingsScreen(navigator: DestinationsNavigator) {
    val listItems = arrayOf(2, 4, 6, 8)
    var selectedValue by remember { mutableStateOf(listItems[0]) }
    var cheats by remember { mutableStateOf(false) }
    var tips by remember { mutableStateOf(false) }
    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "answers", modifier = Modifier.weight(1f))
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.weight(1f),
            ) {
                TextField(
                    value = selectedValue.toString(),
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier.menuAnchor().fillMaxWidth(1f),
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                ) {
                    listItems.forEach { item ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = item.toString(),
                                    modifier = Modifier.wrapContentSize(),
                                )
                            },
                            onClick = {
                                selectedValue = item
                                expanded = false
                                println(selectedValue)
                            },
                        )
                    }
                }
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "cheats", modifier = Modifier.weight(1f))
            Checkbox(
                checked = cheats,
                onCheckedChange = { cheats = it },
                modifier = Modifier.weight(1f),
            )
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "tips", modifier = Modifier.weight(1f))
            Checkbox(
                checked = tips,
                onCheckedChange = { tips = it },
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    LearnArabicAlphabetTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            SettingsScreen(navigator = EmptyDestinationsNavigator)
        }
    }
}
