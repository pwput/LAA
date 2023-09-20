package pl.pw.laa.presentation.audioTest

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
import pl.pw.laa.data.domain.Final
import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.domain.Initial
import pl.pw.laa.data.domain.Isolated
import pl.pw.laa.data.domain.Letter
import pl.pw.laa.data.domain.Medial
import pl.pw.laa.data.repository.IUserPreferencesRepository
import pl.pw.laa.mediaplayer.BaseAudioViewModel
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.viewmodel.IStateViewModel
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class AudioTestViewModel @Inject constructor(private val userPreferencesRepository: IUserPreferencesRepository) :
    BaseAudioViewModel(), IStateViewModel {

    private val viewStateNotifier = MutableStateFlow(AudioTestStateWithContent())
    override val viewState = viewStateNotifier.asStateFlow()
    override fun setShowMessageConsumed() {
        setShowMessageEvent(consumed())
    }

    private val availableForms = mutableListOf<Class<out Form>>()

    init {
        startLoading()
        fetchData()
    }


    private fun fetchData() {
        viewModelScope.launch {

            val preferences = userPreferencesRepository.userPreferencesFlow

            viewStateNotifier.update {
                it.copy(
                    numberOfAnswers = preferences.first().answersCount,
                    areCheatsOn = preferences.first().areCheatsEnabled,
                    areTipsOn = preferences.first().areTipsEnabled,
                    isInitialTested = preferences.first().isInitial,
                    isMedialTested = preferences.first().isMedial,
                    isFinalTested = preferences.first().isFinal,
                    isIsolatedTested = preferences.first().isIsolated,
                )
            }
            getNewState()
            stopLoading()
        }
    }


    private fun setupAvailableForms() {
        Timber.d("Settingup avaliable forms")
        if (!availableForms.isNullOrEmpty())
            availableForms.clear()
        if (viewStateNotifier.value.isInitialTested) availableForms.add(Initial::class.java)
        if (viewStateNotifier.value.isMedialTested) availableForms.add(Medial::class.java)
        if (viewStateNotifier.value.isFinalTested) availableForms.add(Final::class.java)
        if (viewStateNotifier.value.isIsolatedTested) availableForms.add(Isolated::class.java)

        if (availableForms.size == 0) Timber.d("No avaliable forms, you have a big problem!!")
    }

    private fun getNewState() {
        val tmpList = generateLetterList(
            generateSequence(
                0,
                Alphabet.letters.size - 1,
                viewStateNotifier.value.numberOfAnswers
            )
        )
        val tmpForms = mutableListOf<Form>()
        setupAvailableForms()
        for (letter in tmpList) {
            tmpForms.add(letter.getForm(availableForms.random()))
        }
        viewStateNotifier.update {
            it.copy(
                formsList = tmpForms,
                score = it.score + 1,
                rightAnswer = getRandomLetter(tmpList)
            )
        }
    }

    fun onEvent(event: AudioTestEvent): MediaPlayerResponse? {
        return when (event) {
            is AudioTestEvent.ReplayAudio -> {
                startMediaPlayer(event.context, event.letter.vocalizationRaw)
            }

            is AudioTestEvent.GotAnswer -> {
                onAnswerEvent(event.form)
                null
            }
        }
    }

    fun onAnswerEvent(form: Form) {
        Timber.d("Answer: $form")
        Timber.d("RightAnswer: ${viewStateNotifier.value.rightAnswer}")
        if (viewStateNotifier.value.rightAnswer!!.hasForm(form)) {
            Timber.d("Win!!!!")
            getNewState()
        } else {
            if (viewStateNotifier.value.areTipsOn) setShowMessageEvent(
                triggered(
                    arrayOf(
                        Alphabet.getLetterName(form),
                        form.getName().lowercase()
                    )
                )
            )
            viewStateNotifier.update {
                it.copy(
                    mistakes = it.mistakes + 1
                )
            }
        }
    }

    private fun getRandomLetter(list: List<Letter>) = list[Random.nextInt(list.indices)]

    private fun generateLetterList(set: Set<Int>): List<Letter> {
        val tmp = mutableListOf<Letter>()
        for (i in set) {
            tmp.add(Alphabet.letters[i])
        }
        return tmp
    }


    private fun setShowMessageEvent(state: StateEventWithContent<Array<String>>) {
        viewStateNotifier.update {
            it.copy(
                showSnackbarEvent = state
            )
        }
    }

    private fun generateSequence(startNumber: Int, endNumber: Int, size: Int): Set<Int> {
        return generateSequence {
            Random.nextInt(startNumber..endNumber)
        }
            .distinct()
            .take(size)
            .sorted()
            .toSet()
    }
}
