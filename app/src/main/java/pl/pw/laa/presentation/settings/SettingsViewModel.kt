package pl.pw.laa.presentation.settings


import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.pw.laa.data.presistence.AppConfig
import pl.pw.laa.BaseViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val appConfig: AppConfig,
) : BaseViewModel() {

    private val  viewStateNotifier = MutableStateFlow(SettingsState())
    val viewState = viewStateNotifier.asStateFlow()
    init {
        startLoading()
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            viewStateNotifier.update {
                it.copy(
                    numbers = appConfig.answers.getValue(),
                    cheats = appConfig.cheats.getValue(),
                    tips = appConfig.tips.getValue(),
                    isInitialTested = appConfig.initial.getValue(),
                    isMedialTested = appConfig.medial.getValue(),
                    isFinalTested = appConfig.final.getValue(),
                    isIsolatedTested = appConfig.isolated.getValue(),
                )
        }
            stopLoading()
        }
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
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsFinalTested to ${event.isForm}")
                        appConfig.final.setValue(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisInitialTested ->
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsInitialTested to ${event.isForm}")
                        appConfig.initial.setValue(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisIsolatedTested ->
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsIsolatedTested to ${event.isForm}")
                        appConfig.isolated.setValue(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisMedialTested ->
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsMedialTested to ${event.isForm}")
                        appConfig.medial.setValue(event.isForm)
                        fetchData()
                    }
        }}


    private fun canFormBeChanged(newValue: Boolean): Boolean {
        if (newValue) return true
        if (countOfForms() > 1)  return true
        setShowMessageEvent(triggered)
        return false
    }

    private fun setShowMessageEvent(state: StateEvent){
        viewStateNotifier.update {
            it.copy(
                showMessageEvent = state
            )
        }
    }

    private fun countOfForms():Int{
        var sum = 0
        if (viewState.value.isInitialTested) sum += 1
        if (viewState.value.isMedialTested) sum += 1
        if (viewState.value.isFinalTested) sum += 1
        if (viewState.value.isIsolatedTested) sum += 1
        return sum
    }
    fun setShowMessageConsumed() {
        setShowMessageEvent(consumed)
    }
}
