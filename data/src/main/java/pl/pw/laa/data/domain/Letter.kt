package pl.pw.laa.data.domain

data class Letter(
    val isolated: Isolated,
    val final: Final,
    val medial: Medial,
    val initial: Initial,
    val name: String,
    val vocalizationRaw: Int,
) {

    fun hasForm(form: Form): Boolean {
        if (this.initial == form) return true
        if (this.medial == form) return true
        if (this.final == form) return true
        if (this.isolated == form) return true
        return false
    }

    fun getForm(form: Class<out Form>) = when (form) {
        Initial::class.java -> this.initial
        Medial::class.java -> this.medial
        Final::class.java -> this.final
        Isolated::class.java -> this.isolated
        else -> this.initial
    }

    override fun toString(): String {
        return "${this.name},${this.isolated},${this.final},${this.medial},${this.initial}"
    }
}
