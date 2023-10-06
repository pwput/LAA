package pl.pw.laa.presentation.alphabet

import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.domain.Letter
import pl.pw.laa.mediaplayer.BaseAudioViewModel
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.presentation.quiz.QuizState
import pl.pw.laa.viewmodel.ISnackbarViewModel
import pl.pw.laa.viewmodel.IStateViewModel
import javax.inject.Inject

@HiltViewModel
class AlphabetTableViewModel @Inject constructor() :
    BaseAudioViewModel(), IStateViewModel, ISnackbarViewModel {

    private val viewStateNotifier = MutableStateFlow(AlphabetTableState())
    override val viewState = viewStateNotifier.asStateFlow()
    override fun setShowMessageConsumed() {
        setShowMessageEvent(consumed())
    }

    fun onEvent(event: AlphabetTableEvent): MediaPlayerResponse {
        when (event) {
            is AlphabetTableEvent.PlayLetterAudio -> {
                showSnackbar(event.letter)
                return play(event.context, event.letter.vocalizationRaw)
            }
        }
    }

    private fun showSnackbar(letter: Letter) {
        setShowMessageEvent(
            triggered(
                arrayOf(
                    letter.name
                )
            )
        )
    }

    private fun setShowMessageEvent(state: StateEventWithContent<Array<String>>) {
        viewStateNotifier.update {
            it.copy(
                showSnackbarEvent = state
            )
        }
    }
}
