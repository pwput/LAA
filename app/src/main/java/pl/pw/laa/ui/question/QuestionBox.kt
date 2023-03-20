package pl.pw.laa.ui.question

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pw.laa.ui.theme.MyApplicationTheme

@Composable
fun QuestionBox(
    content: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().aspectRatio(1f)
            .border(2.dp, Color.Red, shape = RoundedCornerShape(5))
            .clip(RoundedCornerShape(25))
            .then(modifier)
    ) {
        Text(
            text = content,
            fontSize = 36.sp,
            color = textColor
        )
    }
}

@Preview()
@Composable
fun QuestionBoxPreview() {
    MyApplicationTheme() {
        QuestionBox(
            content = "thaa",
            modifier = Modifier.background(Color.Green).size(100.dp)
        )
    }
}
