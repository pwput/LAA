package pl.pw.laa.domain

data class Letter(
    val isolated: Isolated,
    val final: Final,
    val medial: Medial,
    val initial: Initial,
    val name: String,
    val vocalizationRaw: Int
){
    override fun toString(): String {
        return "${this.name},${this.isolated},${this.final},${this.medial},${this.initial}"
    }
}