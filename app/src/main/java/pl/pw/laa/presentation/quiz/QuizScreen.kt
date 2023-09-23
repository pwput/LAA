package pl.pw.laa.presentation.quiz


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
import pl.pw.laa.data.domain.Form
import pl.pw.laa.presentation.quiz.components.QuizAnswersButtonGroup
import pl.pw.laa.presentation.quiz.components.QuizTopBar
import pl.pw.laa.presentation.quiz.components.QuizQuestionBox
import pl.pw.laa.Orientation
import pl.pw.laa.R
import pl.pw.laa.annotation.preview.PreviewsLandscape
import pl.pw.laa.annotation.preview.PreviewsPortrait
import pl.pw.laa.componets.IfNotLoading
import pl.pw.laa.componets.LearnArabicAlphabetSurfacePreview
import pl.pw.laa.componets.LoadingScreen
import pl.pw.laa.componets.Message
import pl.pw.laa.componets.SetupSnackbarHostState
import pl.pw.laa.componets.showSnackbar
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.settings.SettingsState
import pl.pw.laa.ui.theme.LearnArabicAlphabetTheme

private val paddingValues = PaddingValues(16.dp, 0.dp, 16.dp, 16.dp)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Destination
@Composable
fun QuestionScreen(
    navigator: DestinationsNavigator,
    padding: PaddingValues,
    snackbarHostState: SnackbarHostState,
    viewModel: QuizViewModel = hiltViewModel(),
    viewState: QuizStateWithContent = viewModel.viewState.collectAsStateWithLifecycle().value

) {
    IfNotLoading(isLoading = viewModel.isLoading()) {
        if (Orientation.isLandscape()) {
            QuestionScreenContentLandscape(
                viewState,
                viewModel::onEvent,
                viewModel::onAnswerEvent,
                viewModel.showIcon,
            )
        } else {
            QuestionScreenContentPortrait(
                viewState,
                viewModel::onEvent,
                viewModel::onAnswerEvent,
                viewModel.showIcon,
            )
        }
    }
    val context = LocalContext.current

    EventEffect(
        event = viewState.showSnackbarEvent,
        onConsumed = viewModel::setShowMessageConsumed
    ) {
        snackbarHostState.showSnackbar(
            Message(context.resources.getString(R.string.audiotest_snackbar_text, it[0], it[1]))
        )
    }
}

@Composable
fun QuestionScreenContentLandscape(
    state: QuizStateWithContent,
    onEvent: (QuizEvent) -> MediaPlayerResponse?,
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
            QuizTopBar(state, modifier = Modifier.padding(0.dp))
            QuizQuestionBox(state, showIcon, onEvent)
        }
        QuizAnswersButtonGroup(state, onAnswer, modifier = Modifier.weight(0.5f))
    }


}

@Composable
fun QuestionScreenContentPortrait(
    state: QuizStateWithContent,
    onEvent: (QuizEvent) -> MediaPlayerResponse?,
    onAnswer: (Form) -> Unit,
    showIcon: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        QuizTopBar(state, modifier = Modifier.padding(0.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            QuizQuestionBox(state, showIcon, onEvent)
            QuizAnswersButtonGroup(state, onAnswer)
        }
    }
}

//region Previews
@PreviewsPortrait
@Composable
fun QuestionScreenPortrait4Preview() {
    LearnArabicAlphabetSurfacePreview {
        QuestionScreenContentPortrait(
            mockedState4,
            { null },
            {},
            false,
        )
    }
}

@PreviewsLandscape
@Composable
fun QuestionScreenLandscape4Preview() {
    LearnArabicAlphabetSurfacePreview {
        QuestionScreenContentLandscape(
            mockedState4,
            { null },
            {},
            false,
        )
    }
}

@PreviewsPortrait
@Composable
fun QuestionScreenPortrait8Preview() {
    LearnArabicAlphabetSurfacePreview {
        QuestionScreenContentPortrait(
            mockedState8,
            { null },
            {},
            false,
        )
    }
}

@PreviewsLandscape
@Composable
fun QuestionScreenLandscape8Preview() {
    LearnArabicAlphabetSurfacePreview {
        QuestionScreenContentLandscape(
            mockedState8,
            { null },
            {},
            false,
        )
    }
}

private val mockedState4 = QuizStateWithContent(
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

private val mockedState8 = QuizStateWithContent(
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

//endregion