package pl.pw.laa.presentation.audioTest

import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import pl.pw.laa.data.model.Form
import pl.pw.laa.data.model.Letter
import pl.pw.laa.state.BaseState
import pl.pw.laa.state.IAppConfigState
import pl.pw.laa.state.ISnackbarEventStateWithContent



data class AudioTestStateWithContent(
    val formsList: List<Form>? = mutableListOf(),
    val score: Int = 0,
    val mistakes: Int = 0,
    var rightAnswer: Letter? = null,
    override var areCheatsOn: Boolean = false,
    override var numberOfAnswers: Int = 8,
    override var areTipsOn: Boolean = false,
    override var isInitialTested: Boolean = true,
    override var isMedialTested: Boolean = true,
    override var isFinalTested: Boolean = true,
    override var isIsolatedTested: Boolean = true,
    override val showSnackbarEvent: StateEventWithContent<Array<String>> = consumed(),
): BaseState(),ISnackbarEventStateWithContent, IAppConfigState {
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
