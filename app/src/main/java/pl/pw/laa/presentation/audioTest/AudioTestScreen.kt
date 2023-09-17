package pl.pw.laa.presentation.audioTest


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import de.palm.composestateevents.EventEffect
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.model.Form
import pl.pw.laa.presentation.audioTest.components.AnswersBox
import pl.pw.laa.presentation.audioTest.components.AudioTestTopBar
import pl.pw.laa.presentation.audioTest.components.QuestionBox
import pl.pw.laa.Orientation
import pl.pw.laa.R
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.componets.LoadingScreen
import pl.pw.laa.componets.Message
import pl.pw.laa.componets.ShowSnackbar
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

private val paddingValues = PaddingValues(16.dp, 0.dp, 16.dp, 16.dp)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Destination
@Composable
fun QuestionScreen(
    navigator: DestinationsNavigator,
    padding: PaddingValues,
    snackbarHostState: SnackbarHostState,
    viewModel: AudioTestViewModel = hiltViewModel(),
) {
    val viewState: AudioTestStateWithContent by viewModel.viewState.collectAsStateWithLifecycle()

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }, modifier = Modifier.padding(padding)){
        val context = LocalContext.current
        if (viewModel.isLoading) {
            LoadingScreen()
        } else {
            if (Orientation.isLandscape()) {
                QuestionScreenLandscape(
                    viewState,
                    viewModel::onEvent,
                    viewModel::onAnswerEvent,
                    viewModel.showIcon,
                )
            } else {
                QuestionScreenPortrait(
                    viewState,
                    viewModel::onEvent,
                    viewModel::onAnswerEvent,
                    viewModel.showIcon,
                )
            }
        }
        EventEffect(
            event = viewState.showSnackbarEvent,
            onConsumed = viewModel::setShowMessageConsumed
        ) {
            snackbarHostState.ShowSnackbar(
                Message(context.resources.getString(R.string.audiotest_snackbar_text, it[0], it[1]))
            )
        }
    }
}

@Composable
fun QuestionScreenLandscape(
    state: AudioTestStateWithContent,
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
            QuestionBox(state, showIcon, onEvent)
        }
        AnswersBox(state, onAnswer, modifier = Modifier.weight(0.5f))
    }


}

@Composable
fun QuestionScreenPortrait(
    state: AudioTestStateWithContent,
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
            QuestionBox(state, showIcon, onEvent)
            AnswersBox(state, onAnswer)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@PreviewsPortrait
@Composable
fun QuestionScreenPortrait4Preview() {
    LearnArabicAlphabetTheme() {
        Scaffold(topBar = {}) {
            QuestionScreenPortrait(
                mockedState4,
                { null },
                {},
                false,
            )
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@PreviewsLandscape
@Composable
fun QuestionScreenLandscape4Preview() {
    LearnArabicAlphabetTheme() {
        Scaffold(topBar = {}) {
            QuestionScreenLandscape(
                mockedState4,
                { null },
                {},
                false,
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@PreviewsPortrait
@Composable
fun QuestionScreenPortrait8Preview() {
    LearnArabicAlphabetTheme() {
        Scaffold(topBar = {}) {
        QuestionScreenPortrait(
            mockedState8,
            { null },
            {},
            false,
        )
    }
}}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@PreviewsLandscape
@Composable
fun QuestionScreenLandscape8Preview() {
    LearnArabicAlphabetTheme() {
        Scaffold(topBar = {}) {
        QuestionScreenLandscape(
            mockedState8,
            { null },
            {},
            false,
        )
    }
}}

private val mockedState4 = AudioTestStateWithContent(
    listOf(
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
    ),
    1,
    1,
    rightAnswer = Alphabet.letters[0],
    false,
)

private val mockedState8 = AudioTestStateWithContent(
    listOf(
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
        Alphabet.letters[0].final,
    ),
    1,
    1,
    rightAnswer = Alphabet.letters[0],
    false,
)