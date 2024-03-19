package pl.pw.laa.data.repository

import kotlinx.coroutines.flow.Flow
import pl.pw.laa.data.domain.UserPreferences

interface IUserPreferencesRepository {

	val userPreferencesFlow: Flow<UserPreferences>

	suspend fun fetchInitialPreferences(): UserPreferences
	suspend fun updateQuestionsCount(questionsCount: Int)
	suspend fun updateAnswersCount(answersCount: Int)
	suspend fun updateAreCheatsEnabled(areCheatsEnabled: Boolean)
	suspend fun updateAreTipsEnabled(areTipsEnabled: Boolean)
	suspend fun updateIsInitialTested(isInitial: Boolean)
	suspend fun updateIsMedialTested(isMedial: Boolean)
	suspend fun updateIsFinalTested(isFinal: Boolean)
	suspend fun updateIsIsolatedTested(isIsolated: Boolean)
	suspend fun resetPreferences()
}
