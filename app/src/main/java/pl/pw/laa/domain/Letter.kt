package pl.pw.laa.domain

class Letter(
    val isolated: Isolated,
    val final: Final,
    val medial: Medial,
    val initial: Initial,
    val name: String,
    val vocalizationRaw: Int
)
