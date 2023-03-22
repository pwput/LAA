package pl.pw.laa.ui.audioTest

import pl.pw.laa.domain.Letter

class AudioTestState(
    val audioTestLettersList: MutableList<Letter> = mutableListOf(),
    var rightAnswer: Letter? = null,
)
