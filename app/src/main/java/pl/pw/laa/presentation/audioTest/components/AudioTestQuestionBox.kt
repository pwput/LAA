package pl.pw.laa.presentation.audioTest.components

import DevicePreviewsDarkPortrait
import DevicePreviewsLightPortrait
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.model.Letter
import pl.pw.laa.presentation.audioTest.AudioTestEvent
import pl.pw.laa.presentation.common.annotation.Text
import pl.pw.laa.presentation.common.componets.AudioIcon
import pl.pw.laa.presentation.mediaplayer.MediaPlayerResponse
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun QuestionBox(
    letter: Letter?,
    showIcon: Boolean,
    onEvent: (AudioTestEvent) -> MediaPlayerResponse?,
    modifier: Modifier = Modifier,
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
            .fillMaxWidth(1f)
            .aspectRatio(1.4f, false)
            .background(MaterialTheme.colorScheme.background)
            .padding(PaddingValues(16.dp, 0.dp))
            .border(2.dp, MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(5))
            .clip(RoundedCornerShape(5))
            .background(MaterialTheme.colorScheme.secondaryContainer)
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
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.BottomCenter) {
                Text(
                    letter = letter,
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            }
            Box(modifier = Modifier.weight(1f).fillMaxSize(), contentAlignment = Alignment.Center) {
                AudioIcon(visible, Modifier.fillMaxSize())
            }
        }
    }
}

@DevicePreviewsDarkPortrait
@DevicePreviewsLightPortrait
@Composable
fun QuestionBoxPreviewNoIcon() {
    LearnArabicAlphabetTheme() {
        QuestionBox(
            Alphabet.letters[1],
            true,
            { null },
        )
    }
}

@DevicePreviewsDarkPortrait
@DevicePreviewsLightPortrait
@Composable
fun QuestionBoxPreviewIcon() {
    LearnArabicAlphabetTheme() {
        QuestionBox(
            Alphabet.letters[1],
            false,
            { null },
        )
    }
}
