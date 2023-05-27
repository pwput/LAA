package pl.pw.laa.presentation.alphabet

import android.content.Context
import pl.pw.laa.data.model.Letter

sealed interface AlphabetTableEvent {
    data class PlayLetterAudio(val context: Context, val letter: Letter) : AlphabetTableEvent
}
