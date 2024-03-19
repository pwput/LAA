package pl.pw.laa.data.domain

import pl.pw.laa.data.R

sealed class Form(
		val char: Char,
) {
	abstract val nameResId: Int
	override fun toString(): String {
		return this.char.toString()
	}

	class Isolated(char: Char) : Form(char) {
		override val nameResId: Int = R.string.preference_is_isolated_tested_label
	}

	class Final(char: Char) : Form(char) {
		override val nameResId: Int = R.string.preference_is_final_tested_label
	}

	class Medial(char: Char) : Form(char) {
		override val nameResId: Int = R.string.preference_is_medial_tested_label
	}

	class Initial(char: Char) : Form(char) {
		override val nameResId: Int = R.string.preference_is_initial_tested_label
	}
}