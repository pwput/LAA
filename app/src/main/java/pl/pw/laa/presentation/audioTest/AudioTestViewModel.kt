package pl.pw.laa.presentation.audioTest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import pl.pw.data.model.Final
import pl.pw.data.model.Form
import pl.pw.data.model.Initial
import pl.pw.data.model.Isolated
import pl.pw.data.model.Letter
import pl.pw.data.model.Medial
import pl.pw.laa.presentation.common.toBoolean
import pl.pw.laa.presentation.mediaplayer.BaseAudioViewModel
import pl.pw.laa.presentation.mediaplayer.MediaPlayerResponse
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class AudioTestViewModel @Inject constructor(private val appConfig: pl.pw.data.model.AppConfig) :
    BaseAudioViewModel() {

    var state by mutableStateOf(AudioTestState(null, 0, 0, null))
        private set

    private var numberOfAnswers = 8
    private var cheat = false
    private var tips = false
    private var isInitialTested = true
    private var isMedialTested = true
    private var isFinalTested = true
    private var isIsolated = true

    init {
        startLoading()
        fetchData()
    }

    private val availableForms = mutableListOf<Class<out Form>>()

    private fun fetchData() {
        viewModelScope.launch {
            setupViewModel(
                appConfig.answers.first().value,
                appConfig.cheats.first().value.toBoolean(),
                appConfig.tips.first().value.toBoolean(),
                appConfig.initial.first().value.toBoolean(),
                appConfig.medial.first().value.toBoolean(),
                appConfig.final.first().value.toBoolean(),
                appConfig.isolated.first().value.toBoolean(),
            )
            stopLoading()
        }
    }

    private fun setupViewModel(
        num: Int,
        cheats: Boolean,
        tips: Boolean,
        initial: Boolean,
        medial: Boolean,
        final: Boolean,
        isolated: Boolean,
    ) {
        numberOfAnswers = num
        cheat = cheats
        isInitialTested = initial
        isMedialTested = medial
        isFinalTested = final
        isIsolated = isolated
        this.tips = tips
        setupAvaliableForms()
        getNewState(numberOfAnswers, cheats)
    }

    private fun setupAvaliableForms() {
        Timber.d("Settingup avaliable forms")
        availableForms.clear()
        if (isInitialTested) availableForms.add(Initial::class.java)
        if (isMedialTested) availableForms.add(Medial::class.java)
        if (isFinalTested) availableForms.add(Final::class.java)
        if (isIsolated) availableForms.add(Isolated::class.java)

        if (availableForms.size == 0) Timber.d("No avaliable forms, you have a big problem!!")
    }

    private fun getNewState(size: Int, cheats: Boolean) {
        val tmpList = generateLetterList(generateSequence(0, pl.pw.data.Alphabet.letters.size - 1, size))

        val tmpForms = mutableListOf<Form>()

        for (letter in tmpList) {
            tmpForms.add(letter.getForm(availableForms.random()))
        }

        state = state.copy(
            formsList = tmpForms,
            score = state.score + 1,
            rightAnswer = getRandomLetter(tmpList),
            areCheatsOn = cheats,
        )
    }

    fun onEvent(event: AudioTestEvent): MediaPlayerResponse? {
        return when (event) {
            is AudioTestEvent.ReplayAudio -> {
                startMediaPlayer(event.context, event.letter.vocalizationRaw)
            }

            is AudioTestEvent.GotAnswer -> {
                onAnswer(event.form)
                null
            }
        }
    }

    fun onAnswer(form: Form) {
        Timber.d("Answer: $form")
        Timber.d("RightAnswer: ${state.rightAnswer}")
        if (state.rightAnswer!!.hasForm(form)) {
            Timber.d("Win!!!!")
            getNewState(numberOfAnswers, cheat)
        } else {
            state = state.copy(mistakes = state.mistakes + 1)
        }
    }

    private fun getRandomLetter(list: List<Letter>) = list[Random.nextInt(list.indices)]

    private fun generateLetterList(set: Set<Int>): List<Letter> {
        val tmp = mutableListOf<Letter>()
        for (i in set) {
            tmp.add(pl.pw.data.Alphabet.letters[i])
        }
        return tmp
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
