package pl.pw.laa.presentation.settings

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import pl.pw.data.model.AppConfig
import pl.pw.data.model.AppConfigKey
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
import pl.pw.laa.presentation.common.toBoolean
import pl.pw.laa.presentation.common.toInt
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    val appConfig: AppConfig,
    private val repository: AppConfigKeyRepository,
) : BaseViewModel() {

    var state by mutableStateOf(SettingsState(8,
        cheats = true,
        tips = true,
        isInitialTested = true,
        isMedialTested = true,
        isFinalTested = true,
        isIsolatedTested = true
    ))
        private set

    private var numberOfAnswers = 8
    private var cheat = false
    private var tips = false
    private var isInitialTested = true
    private var isMedialTested = true
    private var isFinalTested = true
    private var isIsolated = true

    init {
        startLoading()
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            setupViewModel(
                appConfig.answers.first().value,
                appConfig.cheats.first().value.toBoolean(),
                appConfig.tips.first().value.toBoolean(),
                appConfig.initial.first().value.toBoolean(),
                appConfig.medial.first().value.toBoolean(),
                appConfig.final.first().value.toBoolean(),
                appConfig.isolated.first().value.toBoolean(),
            )
            stopLoading()
        }
    }

    private fun setupViewModel(
        num: Int,
        cheats: Boolean,
        tips: Boolean,
        initial: Boolean,
        medial: Boolean,
        final: Boolean,
        isolated: Boolean,
    ) {
        numberOfAnswers = num
        cheat = cheats
        isInitialTested = initial
        isMedialTested = medial
        isFinalTested = final
        isIsolated = isolated
        this.tips = tips
        getNewState()
    }

    private fun getNewState() {
        state = state.copy(
            numbers = numberOfAnswers,
            cheats = cheat,
            tips = tips,
            isInitialTested = isInitialTested,
            isMedialTested = isMedialTested,
            isFinalTested = isFinalTested,
            isIsolatedTested = isIsolated
        )
    }

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
                    fetchData()
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
                    fetchData()
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
                    fetchData()
                }

            is SettingsEvent.SetisFinalTested ->
                if (canChange(event.isForm))
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting appConfigIsFinalTested to ${event.isForm}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsFinalTested,
                            event.isForm.toInt(),
                        ),
                    )
                    fetchData()
                }

            is SettingsEvent.SetisInitialTested ->
                if (canChange(event.isForm))
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting appConfigIsInitialTested to ${event.isForm}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsInitialTested,
                            event.isForm.toInt(),
                        ),
                    )
                    fetchData()
                }

            is SettingsEvent.SetisIsolatedTested ->
                if (canChange(event.isForm))
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting appConfigIsIsolatedTested to ${event.isForm}")

                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsIsolatedTested,
                            event.isForm.toInt(),
                        ),
                    )
                    fetchData()
                }

            is SettingsEvent.SetisMedialTested ->
                if (canChange(event.isForm))
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting appConfigIsMedialTested to ${event.isForm}")
                    repository.addAppConfigKey(
                        AppConfigKeyNew(
                            appConfigIsMedialTested,
                            event.isForm.toInt(),
                        ),
                    )
                    fetchData()
                }
        }
    }

    fun canChange(newValue: Boolean): Boolean{
        var sum  = 0
        if (isIsolated) sum+=1
        if (isInitialTested) sum+=1
        if (isMedialTested) sum+=1
        if (isFinalTested) sum+=1

        if (newValue) return true
        if (sum > 1 ) return true
        return false
    }

}
