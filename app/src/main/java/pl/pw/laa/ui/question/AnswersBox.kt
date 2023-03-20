package pl.pw.laa.ui.question

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.ui.theme.MyApplicationTheme

@Composable
fun AnswersBox(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            AnswerButton(content = "aa", onClick = {}, modifier = Modifier.weight(1f))
            AnswerButton(content = "cc", onClick = {}, modifier = Modifier.weight(1f))
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            AnswerButton(content = "bb", onClick = {}, modifier = Modifier.weight(1f))
            AnswerButton(content = "dd", onClick = {}, modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun AnswersBoxPreview() {
    MyApplicationTheme() {
        Surface() {
            AnswersBox()
        }
    }
}
