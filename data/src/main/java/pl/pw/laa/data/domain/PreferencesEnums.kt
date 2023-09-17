package pl.pw.laa.data.domain

import pl.pw.laa.data.R
    interface IPreferencesEnum {
        val labelId: Int
    }

    enum class FormPreference : IPreferencesEnum {
        Initial {
            override val labelId: Int = R.string.prefernece_is_initial_display_label
        },
        Medial {
            override val labelId: Int = R.string.prefernece_is_medial_display_label
        },
        Final {
            override val labelId: Int = R.string.prefernece_is_final_display_label
        },
        Isolated {
            override val labelId: Int = R.string.prefernece_is_isolated_display_label
        }
    }

    enum class BooleanPreference : IPreferencesEnum {
        AreCheatsEnabled {
            override val labelId: Int = R.string.prefernece_are_cheats_display_label
        },
        AreTipsEnabled {
            override val labelId: Int = R.string.prefernece_are_tips_display_label
        }
    }

    enum class IntPreference : IPreferencesEnum {
        AnswersCount {
            override val labelId: Int = R.string.prefernece_are_answers_display_label
        }
    }
