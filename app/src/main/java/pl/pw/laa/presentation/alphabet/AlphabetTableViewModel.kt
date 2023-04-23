package pl.pw.laa.presentation.alphabet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.presentation.common.BaseAudioViewModel
import pl.pw.laa.presistence.AppConfigKeyRepository
import javax.inject.Inject

@HiltViewModel
class AlphabetTableViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseAudioViewModel(repository) {

    var showIcon by mutableStateOf(false)
        private set

    override var onStartPlayingCallback: () -> Unit = { showIcon = true }
    override var onFinishPlayingCallback: () -> Unit = { showIcon = false }

    fun onEvent(event: AlphabetTableEvent):Boolean {
        when (event) {
            is AlphabetTableEvent.PlayAudioForLetter -> {
                createMediaPlayer(event.context, event.letter.vocalizationRaw)
                return startMediaPlayer()
            }
        }
    }
}
