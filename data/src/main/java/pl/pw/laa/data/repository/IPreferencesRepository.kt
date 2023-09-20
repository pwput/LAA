package pl.pw.laa.data.repository

import kotlinx.coroutines.flow.Flow
import pl.pw.laa.data.domain.UserPreferences

interface IUserPreferencesRepository {

    val userPreferencesFlow: Flow<UserPreferences>

    suspend fun fetchInitialPreferences(): UserPreferences
    suspend fun updateAnswersCount(answersCount: Int)
    suspend fun updateAreCheatsEnabled(areCheatsEnabled: Boolean)
    suspend fun updateAreTipsEnabled(areTipsEnabled: Boolean)
    suspend fun updateIsInitial(isInitial: Boolean)
    suspend fun updateIsMedial(isMedial: Boolean)
    suspend fun updateIsFinal(isFinal: Boolean)
    suspend fun updateIsIsolated(isIsolated: Boolean)
    suspend fun resetPreferences()
}
