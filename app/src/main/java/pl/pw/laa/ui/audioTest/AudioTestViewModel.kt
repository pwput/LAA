package pl.pw.laa.ui.audioTest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.slf4j.LoggerFactory
import pl.pw.laa.data.Alphabet
import pl.pw.laa.domain.Letter
import kotlin.random.Random
import kotlin.random.nextInt

class AudioTestViewModel : ViewModel() {

    companion object {
        private val LOG = LoggerFactory.getLogger(AudioTestViewModel::class.java.simpleName)
    }

    var state by mutableStateOf(AudioTestState())
        private set

    init {
        getNewState(8)
    }

    fun onAnswer(letter: Letter) {
        LOG.debug("Answer: $letter")
        LOG.debug("RightAnswer: ${state.rightAnswer}")
        if (letter == state.rightAnswer) {
            LOG.debug("Win!!!!")
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
