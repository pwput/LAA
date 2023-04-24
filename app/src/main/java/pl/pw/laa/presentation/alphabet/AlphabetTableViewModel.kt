package pl.pw.laa.presentation.alphabet

import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.presentation.mediaplayer.BaseAudioViewModel
import pl.pw.laa.presentation.mediaplayer.MediaPlayerResponse
import pl.pw.laa.data.presistence.AppConfigKeyRepository
import javax.inject.Inject

@HiltViewModel
class AlphabetTableViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseAudioViewModel(repository) {

    fun onEvent(event: AlphabetTableEvent): MediaPlayerResponse {
        when (event) {
            is AlphabetTableEvent.PlayLetterAudio -> {
                return startMediaPlayer(event.context, event.letter.vocalizationRaw)
            }
        }
    }
}
