package pl.pw.laa.common.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.common.viewmodel.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class BaseAudioViewModel @Inject constructor() :
		BaseViewModel() {

	private var raw: Int = 0
	private var mediaPlayer: MediaPlayer = MediaPlayer()

	var showIcon by mutableStateOf(false)
		private set

	fun play(context: Context, newRaw: Int): MediaPlayerResponse {
		return try {
			stopMediaPlayer()
			createMediaPlayer(context, newRaw)
			startMediaPlayer()
			MediaPlayerResponse.Success
		} catch (
				e: Exception,
		) {
			Timber.w(e, "Error occurred while setting Creating MediaPlayer.")
			MediaPlayerResponse.Error
		}
	}

	private fun createMediaPlayer(context: Context, raw: Int) {
		Timber.d("Crating MediaPlayer for raw:$raw.")
		mediaPlayer = MediaPlayer.create(context, raw)
		this.raw = raw
	}

	private fun startMediaPlayer() {
		Timber.d("Starting MediaPlayer for raw: $raw")
		mediaPlayer.start()
		showIcon = true
		mediaPlayer.setOnCompletionListener {
			stopMediaPlayer()
		}
	}

	private fun stopMediaPlayer() {
		try {
			mediaPlayer.release()
			showIcon = false
			Timber.d("MediaPlayer has stopped.")
		} catch (
				e: Exception,
		) {
			Timber.w(e, "Error occurred while stopping Media Player.")
		}
	}
}
