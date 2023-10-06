package pl.pw.laa.presentation.quiz

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.repository.IUserPreferencesRepository
import pl.pw.laa.mediaplayer.BaseAudioViewModel
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.state.UserPreferencesState
import pl.pw.laa.viewmodel.ISnackbarViewModel
import pl.pw.laa.viewmodel.IStateViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val userPreferencesRepository: IUserPreferencesRepository) :
    BaseAudioViewModel(), IStateViewModel, ISnackbarViewModel {

    private val viewStateNotifier = MutableStateFlow(QuizState())
    override val viewState = viewStateNotifier.asStateFlow()

    private fun resetState() {
        viewStateNotifier.value = viewStateNotifier.value.resetState()
    }

    init {
        startLoading()
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val preferences = userPreferencesRepository.userPreferencesFlow
            viewStateNotifier.update {
                it.copy(
                    preferences = UserPreferencesState(
                        questionsCount = preferences.first().questionsCount,
                        answersCount = preferences.first().answersCount,
                        areCheatsEnabled = preferences.first().areCheatsEnabled,
                        areTipsEnabled = preferences.first().areTipsEnabled,
                        isInitialTested = preferences.first().isInitial,
                        isMedialTested = preferences.first().isMedial,
                        isFinalTested = preferences.first().isFinal,
                        isIsolatedTested = preferences.first().isIsolated,
                    )
                )
            }
            resetState()
            stopLoading()
        }
    }

    //region Events
    fun onEvent(event: QuizEvent): MediaPlayerResponse? {
        return when (event) {
            is QuizEvent.ReplayAudio -> {
                play(event.context, event.letter.vocalizationRaw)
            }

            is QuizEvent.GotAnswer -> {
                onAnswerEvent(event.form)
                null
            }

            is QuizEvent.HideDialog -> {
                hideDialog()
                startLoading()
                fetchData()
                null
            }
        }
    }

    fun onAnswerEvent(form: Form) {
        val rightAnswer = viewStateNotifier.value.currentQuestion().rightAnswer
        if (viewStateNotifier.value.currentQuestion().rightAnswer!!.hasForm(form)) {
            Timber.d("Correct answer")
            onCorrect()
        } else {
            Timber.d("Wrong answer, right answer: ${rightAnswer.toString()}")
            onMistake()
            showWrongAnswerMessage(form)
        }
    }

    private fun onCorrect() {
        if (!viewStateNotifier.value.isCurrentQuestionLast())
            viewStateNotifier.update {
                it.copy(
                    score = it.score + 1,
                    currentQuestionIndex = it.currentQuestionIndex + 1
                )
            }
        else {
            viewStateNotifier.update {
                it.copy(
                    currentQuestionIndex = it.currentQuestionIndex + 1
                )
            }
            showDialog()

        }
    }

    private fun onMistake() {
        viewStateNotifier.update {
            it.copy(
                mistakes = it.mistakes + 1
            )
        }
    }
    //ednregion


    //region Dialog
    private fun showDialog() {
        viewStateNotifier.update {
            it.copy(
                isDialogVisible = true
            )
        }
    }

    private fun hideDialog() {
        viewStateNotifier.update {
            it.copy(
                isDialogVisible = false
            )
        }
    }
    // endregion

    //region Snackbar
    private fun showWrongAnswerMessage(form: Form) {
        setShowMessageEvent(
            triggered(
                arrayOf(
                    Alphabet.getLetterName(form),
                    form.nameResId.toString()
                )
            )
        )
    }

    override fun setShowMessageConsumed() {
        setShowMessageEvent(consumed())
    }

    private fun setShowMessageEvent(state: StateEventWithContent<Array<String>>) {
        viewStateNotifier.update {
            it.copy(
                showSnackbarEvent = state
            )
        }
    }
    //endregion
}
