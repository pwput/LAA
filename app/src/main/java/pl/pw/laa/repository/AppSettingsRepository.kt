package pl.pw.laa.repository

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pw.laa.model.ApplicationSettings
import pl.pw.laa.presistence.AppSettingsDao
import timber.log.Timber
import javax.inject.Inject

class AppSettingsRepository @Inject constructor(
    private val appSettingsDao: AppSettingsDao,
) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    val appSettings: LiveData<ApplicationSettings> = appSettingsDao.getAppSettings(1)

    init {
        Timber.i("AppSettingsRepository injection")
    }

    fun setAppSettings(applicationSettings: ApplicationSettings) {
        coroutineScope.launch(Dispatchers.IO) {
            appSettingsDao.insertApplicationSettings(applicationSettings)
        }
    }
}
