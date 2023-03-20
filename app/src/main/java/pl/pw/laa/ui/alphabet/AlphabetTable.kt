package pl.pw.laa.ui.alphabet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.ui.theme.MyApplicationTheme

@Composable
fun AlphabetTable(modifier: Modifier = Modifier) {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            TopRow()
            RowDivider()
        }
        items(items = Alphabet.letters) {
            RowForm(letter = it)
            RowDivider()
        }
    }
}

@Composable
fun RowDivider() {
    Divider(color = Color.Gray, thickness = 1.dp)
}

@Preview
@Composable
fun AlphabetTablePreview() {
    MyApplicationTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            AlphabetTable()
        }
    }
}
