package pl.pw.laa.data.domain

data class Letter(
		val isolated: Form.Isolated,
		val final: Form.Final,
		val medial: Form.Medial,
		val initial: Form.Initial,
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
		Form.Initial::class.java -> this.initial
		Form.Medial::class.java -> this.medial
		Form.Final::class.java -> this.final
		Form.Isolated::class.java -> this.isolated
		else -> this.initial
	}

	override fun toString(): String {
		return "${this.name},${this.isolated},${this.final},${this.medial},${this.initial}"
	}
}
