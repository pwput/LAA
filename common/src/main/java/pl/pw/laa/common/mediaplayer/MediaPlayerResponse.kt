package pl.pw.laa.common.mediaplayer

sealed interface MediaPlayerResponse {
	data object Success : MediaPlayerResponse
	data object AlreadyPlayingRequestedAudio : MediaPlayerResponse
	data object Error : MediaPlayerResponse
}

