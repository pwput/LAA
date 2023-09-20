package pl.pw.laa.data.domain

import pl.pw.laa.data.R
    interface IPreferencesEnum {
        val labelId: Int
    }

    enum class FormPreference : IPreferencesEnum {
        IsInitial {
            override val labelId: Int = R.string.prefernece_is_initial_label
        },
        IsMedial {
            override val labelId: Int = R.string.prefernece_is_medial_label
        },
        IsFinal {
            override val labelId: Int = R.string.prefernece_is_final_label
        },
        IsIsolated {
            override val labelId: Int = R.string.prefernece_is_isolated_label
        }
    }

    enum class BooleanPreference : IPreferencesEnum {
        AreCheatsEnabled {
            override val labelId: Int = R.string.prefernece_are_cheats_label
        },
        AreTipsEnabled {
            override val labelId: Int = R.string.prefernece_are_tips_label
        }
    }

    enum class IntPreference : IPreferencesEnum {
        AnswersCount {
            override val labelId: Int = R.string.prefernece_are_answers_label
        }
    }
