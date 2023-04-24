package pl.pw.laa.presentation.audioTest

import android.content.Context
import pl.pw.laa.domain.Letter

sealed interface AudioTestEvent {
    data class ReplayAudio(val context: Context, val letter: Letter) : AudioTestEvent
    data class GotAnswer(val letter: Letter) : AudioTestEvent
}
