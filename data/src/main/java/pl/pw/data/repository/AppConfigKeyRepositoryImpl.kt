package pl.pw.data.repository

import kotlinx.coroutines.flow.Flow
import pl.pw.data.dao.AppConfigKeyDao
import pl.pw.data.model.AppConfigKey

import pl.pw.data.presistence.AppConfigKeyRepository
import pl.pw.data.presistence.DefaultKeys
import timber.log.Timber

class AppConfigKeyRepositoryImpl(
    private val appConfigKeyDao:
    AppConfigKeyDao,
) : AppConfigKeyRepository {
    override fun getAppConfigKey(keyName: String): Flow<AppConfigKey> {
        Timber.d("Getting AppConfigKey for key Name:$keyName")
        return appConfigKeyDao.getAppSettingsKey(keyName)
    }

    override suspend fun addAppConfigKey(key: AppConfigKey) {
        Timber.d("Setting AppConfigKey for key: ${key.key}, value: ${key.value}")
        appConfigKeyDao.insertApplicationSettings(key)
    }

    override suspend fun initDb() {
        val list = DefaultKeys.all
        for (i in list) {
            appConfigKeyDao.insertApplicationSettings(i)
        }
    }

    override suspend fun getNumber(): Int {
        return appConfigKeyDao.getNumber()
    }
}
