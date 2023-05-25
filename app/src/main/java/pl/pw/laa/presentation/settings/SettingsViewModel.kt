package pl.pw.laa.presentation.settings

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pw.data.model.AppConfig
import pl.pw.data.model.AppConfigKeyNew
import pl.pw.data.model.KeyNames.appConfigAnswers
import pl.pw.data.model.KeyNames.appConfigCheats
import pl.pw.data.model.KeyNames.appConfigIsFinalTested
import pl.pw.data.model.KeyNames.appConfigIsInitialTested
import pl.pw.data.model.KeyNames.appConfigIsIsolatedTested
import pl.pw.data.model.KeyNames.appConfigIsMedialTested
import pl.pw.data.model.KeyNames.appConfigTips
import pl.pw.data.presistence.AppConfigKeyRepository
import pl.pw.laa.presentation.common.BaseViewModel
import pl.pw.laa.presentation.common.toInt
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    val appConfig: AppConfig,
    private val repository: AppConfigKeyRepository,
) : BaseViewModel() {

    fun onEvent(event: SettingsEvent) {
        when (event) {
            is SettingsEvent.SetAnswersCount ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting ac to ${event.answersCount}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigAnswers,
                            event.answersCount,
                        ),
                    )
                }

            is SettingsEvent.SetAreCheatsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting cheets to ${event.areCheatsOn}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigCheats,
                            event.areCheatsOn.toInt(),
                        ),
                    )
                }

            is SettingsEvent.SetAreTipsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.areTipsOn}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigTips,
                            event.areTipsOn.toInt(),
                        ),
                    )
                }

            is SettingsEvent.SetisFinalTested ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.isForm}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsFinalTested,
                            event.isForm.toInt(),
                        ),
                    )
                }

            is SettingsEvent.SetisInitialTested ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.isForm}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsInitialTested,
                            event.isForm.toInt(),
                        ),
                    )
                }

            is SettingsEvent.SetisIsolatedTested ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.isForm}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsIsolatedTested,
                            event.isForm.toInt(),
                        ),
                    )
                }

            is SettingsEvent.SetisMedialTested ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.isForm}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsMedialTested,
                            event.isForm.toInt(),
                        ),
                    )
                }
        }
    }
}
