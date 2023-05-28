package pl.pw.laa.audioquiz

import android.content.Context
import pl.pw.laa.data.model.Form
import pl.pw.laa.data.model.Letter

sealed interface AudioTestEvent {
    data class ReplayAudio(val context: Context, val letter: Letter) : AudioTestEvent
    data class GotAnswer(val form: Form) : AudioTestEvent
}
