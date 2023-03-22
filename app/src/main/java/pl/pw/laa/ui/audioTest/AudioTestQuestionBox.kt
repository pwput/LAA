package pl.pw.laa.ui.audioTest

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Letter
import pl.pw.laa.ui.common.AudioIcon
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun QuestionBox(
    letter: Letter,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
) {
    var first by remember { mutableStateOf(true) }
    var last by remember { mutableStateOf(letter) }

    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }
    val mediaPlayer = MediaPlayer.create(context, letter.vocalizationRaw)
    val onCompletionListener = MediaPlayer.OnCompletionListener {
        mediaPlayer.release()
        visible = false
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .aspectRatio(1f)
            .border(2.dp, Color.Red, shape = RoundedCornerShape(5))
            .clip(RoundedCornerShape(25))
            .then(modifier)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
            ) {
                visible = true
                mediaPlayer.start()
                mediaPlayer.setOnCompletionListener(onCompletionListener)
            },
    ) {
        Text(
            text = letter.toString(),
            fontSize = 36.sp,
            color = textColor,
        )
        AudioIcon(modifier = Modifier.size(100.dp), visible)
    }
    if (first || last != letter) {
        mediaPlayer.start()
        first = false
        last = letter
    }
}

@Preview()
@Composable
fun QuestionBoxPreview() {
    LearnArabicAlphabetTheme() {
        QuestionBox(
            letter = Alphabet.letters[0],
            modifier = Modifier
                .background(Color.Green)
                .size(100.dp),
        )
    }
}
