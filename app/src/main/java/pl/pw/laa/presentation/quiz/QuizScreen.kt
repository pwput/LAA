package pl.pw.laa.presentation.quiz

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import de.palm.composestateevents.EventEffect
import de.palm.composestateevents.consumed
import pl.pw.laa.Orientation
import pl.pw.laa.R
import pl.pw.laa.componets.AlertDialog
import pl.pw.laa.componets.IfNotLoading
import pl.pw.laa.componets.CustomSnackbarData
import pl.pw.laa.componets.ShowDialog
import pl.pw.laa.componets.showSnackbar
import pl.pw.laa.data.Alphabet
import pl.pw.laa.state.UserPreferencesState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Destination
@Composable
fun QuestionScreen(
    navigator: DestinationsNavigator,
    padding: PaddingValues,
    snackbarHostState: SnackbarHostState,
    viewModel: QuizViewModel = hiltViewModel(),
    viewState: QuizState = viewModel.viewState.collectAsStateWithLifecycle().value

) {
    Surface(modifier = Modifier.padding(padding)) {
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
    }

    val context = LocalContext.current

    ShowDialog(isVisible =viewState.isDialogVisible) {
        AlertDialog(
            dialogTitle = stringResource(id = R.string.quiz_screen_dialog_title),
            dialogText = stringResource(id = R.string.quiz_screen_dialog_text),
            confirmationText = stringResource(id = R.string.quiz_screen_dialog_confirmation_text),
            onConfirmation = { viewModel.onEvent(QuizEvent.HideDialog) })
    }

    EventEffect(
        event = viewState.showSnackbarEvent,
        onConsumed = viewModel::setShowMessageConsumed
    ) {
        snackbarHostState.showSnackbar(
            CustomSnackbarData(context.resources.getString(R.string.quiz_screen_snackbar_text, it[0], it[1]))
        )
    }
}

//region Previews
val mockedState4 = QuizState(
    0,
    0,
    0,
    listOf(
        SingleQuestion(
            Alphabet.letters[0],
            listOf(
                Alphabet.letters[0].final,
                Alphabet.letters[1].final,
                Alphabet.letters[2].final,
                Alphabet.letters[3].final,
            ),
        ),
    ),
    UserPreferencesState(),
    false,
    consumed(),
)

val mockedState8 = QuizState(
    0,
    0,
    0,
    listOf(
        SingleQuestion(
            Alphabet.letters[0],
            listOf(
                Alphabet.letters[0].final,
                Alphabet.letters[1].final,
                Alphabet.letters[2].final,
                Alphabet.letters[3].final,
                Alphabet.letters[4].final,
                Alphabet.letters[5].final,
                Alphabet.letters[6].final,
                Alphabet.letters[7].final,
            ),
        ),
    ),
    UserPreferencesState(),
    false,
    consumed(),
)
//endregion