package pl.pw.laa.mediaplayer

sealed interface MediaPlayerResponse {
    object Success : MediaPlayerResponse
    object PlayingDifferentAudio : MediaPlayerResponse
    object AlreadyPlayingRequestedAudio : MediaPlayerResponse
    object Error : MediaPlayerResponse
}

