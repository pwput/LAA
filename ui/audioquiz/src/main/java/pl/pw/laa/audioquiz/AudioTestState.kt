package pl.pw.laa.audioquiz

import pl.pw.laa.data.model.Form
import pl.pw.laa.data.model.Letter

data class AudioTestState(
    val formsList: List<Form>? = mutableListOf(),
    val score: Int,
    val mistakes: Int,
    var rightAnswer: Letter?,
    var areCheatsOn: Boolean = false,
) {
    fun isRightAnswer(index: Int): Boolean {
        if (rightAnswer == null) {
            return false
        }

        if (index < 0 || index >= (formsList?.size ?: 0)) {
            return false
        }

        if (rightAnswer!!.hasForm(formsList!![index])) {
            return true
        }

        return false
    }
}
