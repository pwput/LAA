package pl.pw.laa.presentation.menu.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme
import pl.pw.laa.ui.theme.Typography

private val cornerSize = 16.dp
private val textPadding = 16.dp

@Composable
fun MenuButton(
    onClick: () -> Unit,
    content: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    buttonColor: Color = Color.Green,
    buttonBorderColor: Color = Color.Red,
) {
    Box(
        modifier = modifier
            .border(1.dp, buttonBorderColor, shape = RoundedCornerShape(cornerSize))
            .clip(RoundedCornerShape(cornerSize))
            .background(buttonColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {

        Text(
            text = content,
            style = MaterialTheme.typography.titleMedium,
            color = textColor,
            modifier = Modifier.padding(textPadding),
        )
    }
}

@Preview
@Composable
fun MenuButtonPreview() {
    LearnArabicAlphabetTheme() {
        MenuButton(onClick = { /*TODO*/ }, content = "papaj")
    }
}
