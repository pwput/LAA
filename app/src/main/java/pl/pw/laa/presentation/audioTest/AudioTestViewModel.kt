package pl.pw.laa.presentation.audioTest

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.model.Final
import pl.pw.laa.data.model.Form
import pl.pw.laa.data.model.Initial
import pl.pw.laa.data.model.Isolated
import pl.pw.laa.data.model.Letter
import pl.pw.laa.data.model.Medial
import pl.pw.laa.data.presistence.AppConfig
import pl.pw.laa.mediaplayer.BaseAudioViewModel
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import pl.pw.laa.viewmodel.IStateViewModel
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class AudioTestViewModel @Inject constructor(private val appConfig: AppConfig) :
    BaseAudioViewModel(), IStateViewModel {

    private val viewStateNotifier = MutableStateFlow(AudioTestStateWithContent())
    override val viewState = viewStateNotifier.asStateFlow()
    override fun setShowMessageConsumed() {
        setShowMessageEvent(consumed())
    }

    init {
        startLoading()
        fetchData()
    }

    private val availableForms = mutableListOf<Class<out Form>>()

    private fun fetchData() {
        viewModelScope.launch {
            viewStateNotifier.update {
                it.copy(
                    numberOfAnswers = appConfig.answers.getValue(),
                    areCheatsOn = appConfig.cheats.getValue(),
                    areTipsOn = appConfig.tips.getValue(),
                    isInitialTested = appConfig.initial.getValue(),
                    isMedialTested = appConfig.medial.getValue(),
                    isFinalTested = appConfig.final.getValue(),
                    isIsolatedTested = appConfig.isolated.getValue(),
                )
            }
            getNewState()
            stopLoading()
        }
    }


    private fun setupAvailableForms() {
        Timber.d("Settingup avaliable forms")
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
        Timber.d("RightAnswer: ${viewState.value.rightAnswer}")
        if (viewState.value.rightAnswer!!.hasForm(form)) {
            Timber.d("Win!!!!")
            getNewState()
        } else {
            setShowMessageEvent(
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
