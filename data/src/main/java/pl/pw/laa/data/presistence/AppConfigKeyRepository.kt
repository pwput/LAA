package pl.pw.laa.data.presistence

import kotlinx.coroutines.flow.Flow
import pl.pw.laa.data.model.AppConfigKey

interface AppConfigKeyRepository {
    fun getAppConfigKey(keyName: String): Flow<AppConfigKey>

    suspend fun addAppConfigKey(key: AppConfigKey)

    suspend fun initDb()

    suspend fun getNumber(): Int
}
