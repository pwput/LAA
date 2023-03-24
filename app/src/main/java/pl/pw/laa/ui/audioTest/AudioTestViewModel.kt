package pl.pw.laa.ui.audioTest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Letter
import pl.pw.laa.presistence.AppSettingsDao
import pl.pw.laa.repository.AppSettingsRepository
import pl.pw.laa.ui.common.BaseViewModel
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt
@HiltViewModel
class AudioTestViewModel @Inject constructor(private val appSettingsRepository: AppSettingsRepository) : BaseViewModel() {

    var state by mutableStateOf(AudioTestState())
        private set

    init {
        getNewState(8)
    }

    fun onAnswer(letter: Letter) {
        Timber.d("Answer: $letter")
        Timber.d("RightAnswer: ${state.rightAnswer}")
        if (letter == state.rightAnswer) {
            Timber.d("Win!!!!")
            getNewState(8)
        }
    }

    private fun getNewState(size: Int) {
        val tmpIs = generateSequence(0, Alphabet.letters.size - 1, size)
        val tmpAudoList = mutableListOf<Letter>()
        tmpAudoList.addAll(generateLetterList(tmpIs))
        val tmpResoult = tmpAudoList[Random.nextInt(0 until tmpAudoList.size - 1)]
        state = AudioTestState(tmpAudoList, tmpResoult)
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
