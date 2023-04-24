package pl.pw.laa.presentation.audioTest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.presistence.AppConfigKeyRepository
import pl.pw.laa.domain.Letter
import pl.pw.laa.presentation.common.toBoolean
import pl.pw.laa.presentation.mediaplayer.BaseAudioViewModel
import pl.pw.laa.presentation.mediaplayer.MediaPlayerResponse
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class AudioTestViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseAudioViewModel(repository) {

    var state by mutableStateOf(AudioTestState(null, 0, 0,null))
        private set

    private var numberOfAnswers = 8
    private var cheat = false
    private var tips = false

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            setupViewModel(
                numberOfPossibleAnswers.first().value,
                areCheatsOn.first().value.toBoolean(),
                areTipsOn.first().value.toBoolean(),
            )
        }
    }

    private fun setupViewModel(num: Int, cheats: Boolean, tips: Boolean) {
        numberOfAnswers = num
        cheat = cheats
        getNewState(numberOfAnswers, cheats)
    }

    fun onEvent(event: AudioTestEvent): MediaPlayerResponse? {
        return when (event) {
            is AudioTestEvent.ReplayAudio -> {
                startMediaPlayer(event.context, event.letter.vocalizationRaw)
            }

            is AudioTestEvent.GotAnswer -> {
                onAnswer(event.letter)
                null
            }
        }
    }

    fun onAnswer(letter: Letter) {
        Timber.d("Answer: $letter")
        Timber.d("RightAnswer: ${state.rightAnswer}")
        if (letter == state.rightAnswer) {
            Timber.d("Win!!!!")
            getNewState(numberOfAnswers, cheat)
        } else {
            state = state.copy(mistakes = state.mistakes + 1)
        }
    }

    private fun getNewState(size: Int, cheats: Boolean) {
        val tmpList = generateLetterList(generateSequence(0, Alphabet.letters.size - 1, size))

        state = state.copy(
            lettersList = tmpList,
            score = state.score + 1,
            rightAnswer = getRandomLetter(tmpList),
            areCheatsOn = cheats,
        )
    }

    private fun getRandomLetter(list: List<Letter>) = list[Random.nextInt(list.indices)]

    private fun generateLetterList(set: Set<Int>): List<Letter> {
        val tmp = mutableListOf<Letter>()
        for (i in set) {
            tmp.add(Alphabet.letters[i])
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
