package pl.pw.laa.presentation.common

import android.content.Context
import android.media.MediaPlayer
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.presistence.AppConfigKeyRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class BaseAudioViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseViewModel(repository) {

    private var mediaPlayer: MediaPlayer = MediaPlayer()
    private var onCompletionListener: (MediaPlayer) -> Unit = {}
    open var onStartPlayingCallback: () -> Unit = {}
    open var onFinishPlayingCallback: () -> Unit = {}

    fun createMediaPlayer(context: Context, raw: Int) {
        val mp = mediaPlayer
        try {
            if (!mediaPlayer.isPlaying) {
                Timber.d("Crating MediaPlayer for raw:$raw.")
                mediaPlayer = MediaPlayer.create(context, raw)
            } else {
                Timber.d("Cannot create MediaPlayer for raw:$raw, MediaPlayer is currently playing!")
            }
        } catch (
            e: Exception,
        ) {
            Timber.w(e, "Error occurred while setting Creating MediaPlayer.")
        }
    }

    fun setOnCompletionListener(onCompletionListener: (MediaPlayer) -> Unit) {
        Timber.d("Setting OnCompletionListener for MediaPlayer.")
        try {
            mediaPlayer.setOnCompletionListener(onCompletionListener)
        } catch (
            e: Exception,
        ) {
            Timber.w(e, "Error occurred while setting OnCompletionListener.")
        }
    }

    fun startMediaPlayer(): Boolean {
        try {
            if (!mediaPlayer.isPlaying) {
                Timber.d("Starting MediaPlayer for raw: ${mediaPlayer.audioSessionId}")
                mediaPlayer.start()
                onStartPlayingCallback.invoke()
                mediaPlayer.setOnCompletionListener {
                    onCompletionListener
                    onFinishPlayingCallback.invoke()
                    Timber.d("MediaPlayer stopped playing.")
                    stopMediaPlayer()
                }
                return true
            } else {
                Timber.d("Cannot start MediaPlayer for raw:${mediaPlayer.audioSessionId}, MediaPlayer is currently playing!")
            }
        } catch (
            e: Exception,
        ) {
            Timber.w(e, "Error occurred while starting MediaPlayer.")
        }
        return false
    }

    fun setAudioSessionId(raw: Int) {
        Timber.d("Resetting MediaPlayer audioSessionId to raw:$raw.")
        try {
            mediaPlayer.audioSessionId = raw
        } catch (
            e: Exception,
        ) {
            Timber.w(e, "Error occurred while setting AudioSessionId.")
        }
    }

    private fun stopMediaPlayer() {
        Timber.d("Stop MediaPlayer.")
        try {
            mediaPlayer.stop()
        } catch (
            e: Exception,
        ) {
            Timber.w(e, "Error occurred while stopping Media Player.")
        }
    }
}
