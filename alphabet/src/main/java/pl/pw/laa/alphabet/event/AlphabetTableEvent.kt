package pl.pw.laa.alphabet.event

import android.content.Context
import pl.pw.laa.data.domain.Letter

sealed interface AlphabetTableEvent {
	data class PlayLetterAudio(val context: Context, val letter: Letter) : AlphabetTableEvent
}
