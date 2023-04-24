package pl.pw.laa.presentation.audioTest

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
import pl.pw.laa.domain.Letter
import pl.pw.laa.presentation.common.AudioIcon
import pl.pw.laa.presentation.mediaplayer.MediaPlayerResponse
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun QuestionBox(
    letter: Letter?,
    showIcon: Boolean,
    onEvent: (AudioTestEvent) -> MediaPlayerResponse?,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
) {
    var firstAudioPlay by remember { mutableStateOf(true) }
    var previousAudioPlayLetter by remember { mutableStateOf(letter) }

    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }

    if (!showIcon) visible = false

    if (firstAudioPlay || previousAudioPlayLetter != letter) {
        letter?.let {
            onEvent(AudioTestEvent.ReplayAudio(context, letter))
        }
        firstAudioPlay = false
        previousAudioPlayLetter = letter
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .aspectRatio(1f)
            .border(2.dp, Color.Red, shape = RoundedCornerShape(5))
            .clip(RoundedCornerShape(25))
            .then(modifier)
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
            ) {
                letter?.let {
                    val resp = onEvent(AudioTestEvent.ReplayAudio(context, letter))
                    visible =
                        resp is MediaPlayerResponse.Success || resp is MediaPlayerResponse.AlreadyPlayingRequestedAudio
                }
            },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.BottomCenter,) {
                Text(
                    text = letter.toString(),
                    fontSize = 36.sp,
                    color = textColor,

                )
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                AudioIcon(modifier = Modifier.size(100.dp), visible)
            }

        }
    }
}

@Preview()
@Composable
fun QuestionBoxPreview() {
    LearnArabicAlphabetTheme() {
//        QestionBox(
//            letter = Alphabet.letters[0],
//            modifier = Modifier
//                .background(Color.Green)
//                .size(100.dp),
//        )
    }
}
