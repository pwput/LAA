package pl.pw.laa.ui.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.ui.theme.MyApplicationTheme

@Composable
fun QuestionScreen() {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        QuestionBox("pytanie")
        AnswersBox()
    }
}

@Preview
@Composable
fun QuestionScreenPreview() {
    MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            QuestionScreen()
        }
    }
}
