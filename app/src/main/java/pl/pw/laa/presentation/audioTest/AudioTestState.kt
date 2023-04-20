package pl.pw.laa.presentation.audioTest

import pl.pw.laa.domain.Letter

class AudioTestState(
    val lettersList: MutableList<Letter>? = mutableListOf(),
    var rightAnswer: Letter?,
    var areCheatsOn: Boolean = false,
) {
    fun isRightAnswer(index: Int): Boolean {
        if (rightAnswer == null) {
            return false
        }

        if (index < 0 || index >= (lettersList?.size ?: 0)) {
            return false
        }

        if (lettersList!![index].final.char == rightAnswer!!.final.char) {
            return true
        }

        return false
    }
}
