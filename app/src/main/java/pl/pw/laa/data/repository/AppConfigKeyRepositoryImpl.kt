package pl.pw.laa.data.repository

import kotlinx.coroutines.flow.Flow
import pl.pw.laa.data.dao.AppConfigKeyDao
import pl.pw.laa.data.model.AppConfigKey
import pl.pw.laa.data.model.appConfigAnswers
import pl.pw.laa.data.model.appConfigCheats
import pl.pw.laa.data.model.appConfigTips
import pl.pw.laa.data.presistence.AppConfigKeyRepository
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
        val list = listOf(
            AppConfigKey(appConfigAnswers, 8),
            AppConfigKey(appConfigCheats, 1),
            AppConfigKey(appConfigTips, 1),
        )
        for (i in list) {
            appConfigKeyDao.insertApplicationSettings(i)
        }
    }

    override suspend fun getNumber(): Int {
        return appConfigKeyDao.getNumber()
    }
}
