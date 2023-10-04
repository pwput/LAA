package pl.pw.laa.mediaplayer

sealed interface MediaPlayerResponse {
    object Success : MediaPlayerResponse
    object AlreadyPlayingRequestedAudio : MediaPlayerResponse
    object Error : MediaPlayerResponse
}

