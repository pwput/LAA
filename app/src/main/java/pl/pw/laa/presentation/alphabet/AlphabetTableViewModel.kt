package pl.pw.laa.presentation.alphabet

import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.mediaplayer.BaseAudioViewModel
import pl.pw.laa.mediaplayer.MediaPlayerResponse
import javax.inject.Inject

@HiltViewModel
class AlphabetTableViewModel @Inject constructor() :
    BaseAudioViewModel() {

    fun onEvent(event: AlphabetTableEvent): MediaPlayerResponse {
        when (event) {
            is AlphabetTableEvent.PlayLetterAudio -> {
                return startMediaPlayer(event.context, event.letter.vocalizationRaw)
            }
        }
    }
}
