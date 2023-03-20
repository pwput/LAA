package pl.pw.laa.domain

class Letter(
    val isolated: LetterForm,
    val initial: LetterForm,
    val medial: LetterForm,
    val final: LetterForm,
    val name: String,
    val vocalization: String = ""
)
