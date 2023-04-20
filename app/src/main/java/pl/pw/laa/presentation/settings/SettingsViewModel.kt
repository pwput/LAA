package pl.pw.laa.presentation.settings

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pw.laa.model.AppConfigKey
import pl.pw.laa.model.appConfigAnswers
import pl.pw.laa.model.appConfigCheats
import pl.pw.laa.model.appConfigTips
import pl.pw.laa.presentation.common.BaseViewModel
import pl.pw.laa.presentation.common.toInt
import pl.pw.laa.presistence.AppConfigKeyRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val repository: AppConfigKeyRepository,
) : BaseViewModel(repository) {

    fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.SetAnswersCount ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting ac to ${event.answersCount}")

                    repository.addAppConfigKey(
                        AppConfigKey(
                            appConfigAnswers,
                            event.answersCount,
                        ),
                    )
                }

            is SettingsEvent.SetAreCheatsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting cheets to ${event.areCheatsOn}")

                    repository.addAppConfigKey(
                        AppConfigKey(
                            appConfigCheats,
                            event.areCheatsOn.toInt(),
                        ),
                    )
                }
            is SettingsEvent.SetAreTipsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.areTipsOn}")

                    repository.addAppConfigKey(
                        AppConfigKey(
                            appConfigTips,
                            event.areTipsOn.toInt(),
                        ),
                    )
                }
        }
    }
}



