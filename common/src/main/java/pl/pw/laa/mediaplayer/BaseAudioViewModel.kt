package pl.pw.laa.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.viewmodel.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class BaseAudioViewModel @Inject constructor() :
    BaseViewModel() {

    private var raw: Int = 0
    private var mediaPlayer: MediaPlayer = MediaPlayer()

    var showIcon by mutableStateOf(false)
        private set

    fun startMediaPlayer(context: Context, raw: Int): MediaPlayerResponse {
        try {
            if (!mediaPlayer.isPlaying) {
                Timber.d("Crating MediaPlayer for raw:$raw.")
                mediaPlayer = MediaPlayer.create(context, raw)
                this.raw = raw
                Timber.d("Starting MediaPlayer for raw: $raw")
                mediaPlayer.start()
                showIcon = true
                mediaPlayer.setOnCompletionListener {
                    showIcon = false
                    stopMediaPlayer()
                }
                return MediaPlayerResponse.Success
            } else {
                return if (this.raw == raw) {
                    Timber.d("Cannot create MediaPlayer for raw:$raw, MediaPlayer is currently playing this raw!")
                    MediaPlayerResponse.AlreadyPlayingRequestedAudio
                } else {
                    Timber.d("Cannot create MediaPlayer for raw:$raw, MediaPlayer is currently playing different raw, currently playing: ${this.raw}!")
                    MediaPlayerResponse.PlayingDifferentAudio
                }
            }
        } catch (
            e: Exception,
        ) {
            Timber.w(e, "Error occurred while setting Creating MediaPlayer.")
            return MediaPlayerResponse.Error
        }
    }

    private fun stopMediaPlayer() {
        try {
            mediaPlayer.stop()
            Timber.d("MediaPlayer has stopped.")
        } catch (
            e: Exception,
        ) {
            Timber.w(e, "Error occurred while stopping Media Player.")
        }
    }
}
