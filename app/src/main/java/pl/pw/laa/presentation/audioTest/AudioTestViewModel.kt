package pl.pw.laa.presentation.audioTest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Letter
import pl.pw.laa.presentation.common.BaseViewModel
import pl.pw.laa.presentation.common.toBoolean
import pl.pw.laa.presistence.AppConfigKeyRepository
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class AudioTestViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseViewModel(repository) {

    var state by mutableStateOf(AudioTestState(null, null))
        private set

    private var num = 8
    private var cheat = false

    fun onAnswer(letter: Letter) {
        Timber.d("Answer: $letter")
        Timber.d("RightAnswer: ${state.rightAnswer}")
        if (letter == state.rightAnswer) {
            Timber.d("Win!!!!")
            getNewState(num, cheat)
        }
    }

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            setup(numbers.first().value, cheats.first().value.toBoolean())
        }
    }

    fun setup(i: Int, cheats: Boolean) {
        num = i
        cheat = cheats
        getNewState(num, cheats)
    }

    private fun getNewState(size: Int, cheats: Boolean) {
        val tmpIs = generateSequence(0, Alphabet.letters.size - 1, size)
        val tmpAudoList = mutableListOf<Letter>()
        tmpAudoList.addAll(generateLetterList(tmpIs))
        val tmpResoult = tmpAudoList[Random.nextInt(0 until tmpAudoList.size)]
        state = AudioTestState(tmpAudoList, tmpResoult, cheats)
    }

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
