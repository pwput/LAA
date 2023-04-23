package pl.pw.laa.presentation.alphabet

import android.content.Context
import pl.pw.laa.domain.Letter

sealed interface AlphabetTableEvent {
    data class PlayAudioForLetter(val context: Context, val letter: Letter) : AlphabetTableEvent
}
