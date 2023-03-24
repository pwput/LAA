package pl.pw.laa.ui.settings

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.model.ApplicationSettings
import pl.pw.laa.presistence.AppSettingsDao
import pl.pw.laa.repository.AppSettingsRepository
import pl.pw.laa.ui.common.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
     val applicationSettingsDao: AppSettingsDao,
     val applicationSettingsRepository: AppSettingsRepository = AppSettingsRepository(applicationSettingsDao),
) : ViewModel() {
    private var applicationSettings: ApplicationSettings? = null

    init {
        //applicationSettingsRepository.setAppSettings(ApplicationSettings())
        // applicationSettings = applicationSettingsRepository.appSettings.value
        //Timber.d(applicationSettings.toString())
    }
}
