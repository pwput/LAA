package pl.pw.laa.presentation.audioTest.components


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
import androidx.compose.material3.Text
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
import pl.pw.laa.presentation.audioTest.AudioTestEvent
import pl.pw.laa.annotation.preview.DevicePreviewsDarkPortrait
import pl.pw.laa.annotation.preview.DevicePreviewsLightPortrait
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.audioTest.AudioTestStateWithContent
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

@Composable
fun QuestionBox(
    viewState: AudioTestStateWithContent,
    showIcon: Boolean,
    onEvent: (AudioTestEvent) -> MediaPlayerResponse?,
    modifier: Modifier = Modifier,
) {
    var firstAudioPlay by remember { mutableStateOf(true) }
    var previousAudioPlayLetter by remember { mutableStateOf(viewState.rightAnswer) }

    val context = LocalContext.current

    var visible by remember { mutableStateOf(false) }

    if (!showIcon) visible = false

    if (firstAudioPlay || previousAudioPlayLetter != viewState.rightAnswer) {
        viewState.rightAnswer?.let {
            onEvent(AudioTestEvent.ReplayAudio(context, viewState.rightAnswer!!))
        }
        firstAudioPlay = false
        previousAudioPlayLetter = viewState.rightAnswer
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(1f)
            .aspectRatio(1.6f, false)
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
                viewState.rightAnswer?.let {
                    val resp = onEvent(AudioTestEvent.ReplayAudio(context, viewState.rightAnswer!!))
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
                    text = if (viewState.areCheatsEnabled) viewState.rightAnswer.toString() else viewState.rightAnswer?.name ?: "null",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxSize(), contentAlignment = Alignment.Center) {
                pl.pw.laa.componets.AudioIcon(visible, Modifier.fillMaxSize())
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
            AudioTestStateWithContent(),
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
            AudioTestStateWithContent(),
            false,
            { null },
        )
    }
}
