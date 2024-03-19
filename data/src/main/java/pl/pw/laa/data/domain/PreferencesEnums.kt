package pl.pw.laa.data.domain

import pl.pw.laa.data.R

interface IPreferencesEnum {
	val labelId: Int
}

enum class FormPreference : IPreferencesEnum {
	IsInitial {
		override val labelId: Int = R.string.preference_is_initial_tested_label
	},
	IsMedial {
		override val labelId: Int = R.string.preference_is_medial_tested_label
	},
	IsFinal {
		override val labelId: Int = R.string.preference_is_final_tested_label
	},
	IsIsolated {
		override val labelId: Int = R.string.preference_is_isolated_tested_label
	}
}

enum class BooleanPreference : IPreferencesEnum {
	AreCheatsEnabled {
		override val labelId: Int = R.string.preference_are_cheats_enabled_label
	},
	AreTipsEnabled {
		override val labelId: Int = R.string.preference_are_tips_enabled_label
	}
}

enum class IntPreference : IPreferencesEnum {
	AnswersCount {
		override val labelId: Int = R.string.preference_answers_count_label
	},
	QuestionsCount {
		override val labelId: Int = R.string.preference_qestions_count_label
	}
}
