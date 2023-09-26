package pl.pw.laa.quiz

import android.content.Context
import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.domain.Letter

sealed interface QuizEvent {
    data class ReplayAudio(val context: Context, val letter: Letter) : QuizEvent
    data class GotAnswer(val form: Form) : QuizEvent
    object HideDialog : QuizEvent
}
