package pl.pw.laa.presentation.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pw.laa.data.presistence.AppConfig
import pl.pw.laa.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val appConfig: AppConfig,
) : pl.pw.laa.BaseViewModel() {

    var state by mutableStateOf(
        SettingsState(
            8,
            cheats = true,
            tips = true,
            isInitialTested = true,
            isMedialTested = true,
            isFinalTested = true,
            isIsolatedTested = true
        )
    )
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
                appConfig.answers.getValue(),
                appConfig.cheats.getValue(),
                appConfig.tips.getValue(),
                appConfig.initial.getValue(),
                appConfig.medial.getValue(),
                appConfig.final.getValue(),
                appConfig.isolated.getValue(),
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
                    appConfig.answers.setValue(event.answersCount)
                    fetchData()
                }

            is SettingsEvent.SetAreCheatsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting cheets to ${event.areCheatsOn}")
                    appConfig.cheats.setValue(event.areCheatsOn)
                    fetchData()
                }

            is SettingsEvent.SetAreTipsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.areTipsOn}")
                    appConfig.tips.setValue(event.areTipsOn)
                    fetchData()
                }

            is SettingsEvent.SetisFinalTested ->
                if (canChange(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsFinalTested to ${event.isForm}")
                        appConfig.final.setValue(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisInitialTested ->
                if (canChange(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsInitialTested to ${event.isForm}")
                        appConfig.initial.setValue(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisIsolatedTested ->
                if (canChange(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsIsolatedTested to ${event.isForm}")
                        appConfig.isolated.setValue(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisMedialTested ->
                if (canChange(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsMedialTested to ${event.isForm}")
                        appConfig.medial.setValue(event.isForm)
                        fetchData()
                    }
        }
    }

    fun canChange(newValue: Boolean): Boolean {
        var sum = 0
        if (isIsolated) sum += 1
        if (isInitialTested) sum += 1
        if (isMedialTested) sum += 1
        if (isFinalTested) sum += 1

        if (newValue) return true
        if (sum > 1) return true
        return false
    }

}
