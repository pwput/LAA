package pl.pw.laa.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import pl.pw.laa.data.domain.UserPreferences
import timber.log.Timber
import javax.inject.Inject

class UserPreferencesRepository @Inject constructor(private val dataStore: DataStore<Preferences>) :
    IUserPreferencesRepository {

    private companion object {
        const val QUESTIONS_COUNT_KEY_NAME = "pl.pw.laa.questions_count"
        const val ANSWERS_COUNT_KEY_NAME = "pl.pw.laa.answers_count"
        const val ARE_CHEATS_ENABLED_KEY_NAME = "pl.pw.laa.are_cheats_enabled"
        const val ARE_TIPS_ENABLED_KEY_NAME = "pl.pw.laa.are_tips_enabled"
        const val IS_INITIAL_KEY_NAME = "pl.pw.laa.is_initial"
        const val IS_MEDIAL_KEY_NAME = "pl.pw.laa.is_medial"
        const val IS_FINAL_KEY_NAME = "pl.pw.laa.is_final"
        const val IS_ISOLATED_KEY_NAME = "pl.pw.laa.is_isolated"
    }

    private object PreferencesKeys {
        val QUESTIONS_COUNT = intPreferencesKey(QUESTIONS_COUNT_KEY_NAME)
        val ANSWERS_COUNT = intPreferencesKey(ANSWERS_COUNT_KEY_NAME)
        val ARE_CHEATS_ENABLED = booleanPreferencesKey(ARE_CHEATS_ENABLED_KEY_NAME)
        val ARE_TIPS_ENABLES = booleanPreferencesKey(ARE_TIPS_ENABLED_KEY_NAME)
        val IS_INITIAL = booleanPreferencesKey(IS_INITIAL_KEY_NAME)
        val IS_MEDIAL = booleanPreferencesKey(IS_MEDIAL_KEY_NAME)
        val IS_FINAL = booleanPreferencesKey(IS_FINAL_KEY_NAME)
        val IS_ISOLATED = booleanPreferencesKey(IS_ISOLATED_KEY_NAME)
    }


    override val userPreferencesFlow: Flow<UserPreferences> = dataStore.data
        .catch {
            Timber.e("Error reading preferences: ${it.message}")
            emit(emptyPreferences())
        }.map {
            mapUserPreferences(it)
        }

    override suspend fun fetchInitialPreferences() =
        mapUserPreferences(dataStore.data.first().toPreferences())

    override suspend fun updateQuestionsCount(questionsCount: Int) {
        dataStore.edit { preferences ->
            Timber.d("Updating questions count to $questionsCount")
            preferences[PreferencesKeys.QUESTIONS_COUNT] = questionsCount
        }
    }

    override suspend fun updateAnswersCount(answersCount: Int) {
        dataStore.edit { preferences ->
            Timber.d("Updating answers count to $answersCount")
            preferences[PreferencesKeys.ANSWERS_COUNT] = answersCount
        }
    }

    override suspend fun updateAreCheatsEnabled(areCheatsEnabled: Boolean) {
        dataStore.edit { preferences ->
            Timber.d("Updating are cheats enabled to $areCheatsEnabled")
            preferences[PreferencesKeys.ARE_CHEATS_ENABLED] = areCheatsEnabled
        }
    }

    override suspend fun updateAreTipsEnabled(areTipsEnabled: Boolean) {
        dataStore.edit { preferences ->
            Timber.d("Updating are tips enabled to $areTipsEnabled")
            preferences[PreferencesKeys.ARE_TIPS_ENABLES] = areTipsEnabled
        }
    }

    override suspend fun updateIsInitialTested(isInitial: Boolean) {
        dataStore.edit { preferences ->
            Timber.d("Updating is initial to $isInitial")
            preferences[PreferencesKeys.IS_INITIAL] = isInitial
        }
    }

    override suspend fun updateIsMedialTested(isMedial: Boolean) {
        dataStore.edit { preferences ->
            Timber.d("Updating is medial to $isMedial")
            preferences[PreferencesKeys.IS_MEDIAL] = isMedial
        }
    }

    override suspend fun updateIsFinalTested(isFinal: Boolean) {
        dataStore.edit { preferences ->
            Timber.d("Updating is final to $isFinal")
            preferences[PreferencesKeys.IS_FINAL] = isFinal
        }
    }

    override suspend fun updateIsIsolatedTested(isIsolated: Boolean) {
        dataStore.edit { preferences ->
            Timber.d("Updating is isolated to $isIsolated")
            preferences[PreferencesKeys.IS_ISOLATED] = isIsolated
        }
    }

    override suspend fun resetPreferences() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    private fun mapUserPreferences(preferences: Preferences): UserPreferences {
        val questionsCount = preferences[PreferencesKeys.QUESTIONS_COUNT] ?: 5
        val answersCount = preferences[PreferencesKeys.ANSWERS_COUNT] ?: 4
        val areCheatsEnabled = preferences[PreferencesKeys.ARE_CHEATS_ENABLED] ?: false
        val areTipsEnabled = preferences[PreferencesKeys.ARE_TIPS_ENABLES] ?: false
        val isInitialTested = preferences[PreferencesKeys.IS_INITIAL] ?: true
        val isMedialTested = preferences[PreferencesKeys.IS_MEDIAL] ?: false
        val isFinalTested = preferences[PreferencesKeys.IS_FINAL] ?: false
        val isIsolatedTested = preferences[PreferencesKeys.IS_ISOLATED] ?: false
        return UserPreferences(
            questionsCount,
            answersCount,
            areCheatsEnabled,
            areTipsEnabled,
            isInitialTested,
            isMedialTested,
            isFinalTested,
            isIsolatedTested
        )
    }
}
