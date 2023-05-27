package pl.pw.laa.presentation.audioTest

import DevicePreviewsDarkLandscape
import DevicePreviewsDarkPortrait
import DevicePreviewsLightLandscape
import DevicePreviewsLightPortrait
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import pl.pw.data.model.Form
import pl.pw.laa.presentation.audioTest.components.AnswersBox
import pl.pw.laa.presentation.audioTest.components.AudioTestTopBar
import pl.pw.laa.presentation.common.Orientation
import pl.pw.laa.presentation.common.componets.LoadingScreen
import pl.pw.laa.presentation.mediaplayer.MediaPlayerResponse
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

val paddingValues = PaddingValues(16.dp, 0.dp, 16.dp, 16.dp)

@Destination
@Composable
fun QuestionScreen(
    navigator: DestinationsNavigator,
    viewModel: AudioTestViewModel = hiltViewModel(),
) {
    if (viewModel.isLoading) {
        LoadingScreen()
    } else {
        if (Orientation.isLandscape()) {
            QuestionScreenLandscape(
                viewModel.state,
                viewModel::onEvent,
                viewModel::onAnswer,
                viewModel.showIcon,
            )
        } else {
            QuestionScreenPortrait(
                viewModel.state,
                viewModel::onEvent,
                viewModel::onAnswer,
                viewModel.showIcon,
            )
        }
    }
}

@Composable
fun QuestionScreenLandscape(
    state: AudioTestState,
    onEvent: (AudioTestEvent) -> MediaPlayerResponse?,
    onAnswer: (Form) -> Unit,
    showIcon: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(paddingValues)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(0.5f)) {
            AudioTestTopBar(state, modifier = Modifier.padding(0.dp))
            QuestionBox(state.rightAnswer, showIcon, onEvent)
        }
        AnswersBox(state, onAnswer, modifier = Modifier.weight(0.5f))
    }
}

@Composable
fun QuestionScreenPortrait(
    state: AudioTestState,
    onEvent: (AudioTestEvent) -> MediaPlayerResponse?,
    onAnswer: (Form) -> Unit,
    showIcon: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        AudioTestTopBar(state, modifier = Modifier.padding(0.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            QuestionBox(state.rightAnswer, showIcon, onEvent)
            AnswersBox(state, onAnswer)
        }
    }
}

private val mockedState4 = AudioTestState(
    listOf(
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
    ),
    1,
    1,
    rightAnswer = pl.pw.data.Alphabet.letters[0],
    false,
)

private val mockedState8 = AudioTestState(
    listOf(
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
        pl.pw.data.Alphabet.letters[0].final,
    ),
    1,
    1,
    rightAnswer = pl.pw.data.Alphabet.letters[0],
    false,
)

@DevicePreviewsLightPortrait
@DevicePreviewsDarkPortrait
@Composable
fun QuestionScreenPortrait4Preview() {
    LearnArabicAlphabetTheme() {
        QuestionScreenPortrait(
            mockedState4,
            { null },
            {},
            false,
        )
    }
}

@DevicePreviewsLightLandscape
@DevicePreviewsDarkLandscape
@Composable
fun QuestionScreenLandscape4Preview() {
    LearnArabicAlphabetTheme() {
        QuestionScreenLandscape(
            mockedState4,
            { null },
            {},
            false,
        )
    }
}

@DevicePreviewsLightPortrait
@DevicePreviewsDarkPortrait
@Composable
fun QuestionScreenPortrait8Preview() {
    LearnArabicAlphabetTheme() {
        QuestionScreenPortrait(
            mockedState8,
            { null },
            {},
            false,
        )
    }
}

@DevicePreviewsLightLandscape
@DevicePreviewsDarkLandscape
@Composable
fun QuestionScreenLandscape8Preview() {
    LearnArabicAlphabetTheme() {
        QuestionScreenLandscape(
            mockedState8,
            { null },
            {},
            false,
        )
    }
}