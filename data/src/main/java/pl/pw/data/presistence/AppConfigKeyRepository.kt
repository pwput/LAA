package pl.pw.data.presistence

import kotlinx.coroutines.flow.Flow
import pl.pw.data.model.AppConfigKey

interface AppConfigKeyRepository {
    fun getAppConfigKey(keyName: String): Flow<AppConfigKey>

    suspend fun addAppConfigKey(key: AppConfigKey)

    suspend fun initDb()

    suspend fun getNumber(): Int
}
