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
import pl.pw.laa.viewmodel.BaseViewModel
import pl.pw.laa.viewmodel.IStateViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val appConfig: AppConfig,
) : BaseViewModel(), IStateViewModel{

    private val  viewStateNotifier = MutableStateFlow(SettingsState())
    override val viewState = viewStateNotifier.asStateFlow()
    init {
        startLoading()
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            viewStateNotifier.update {
                it.copy(
                    numberOfAnswers = appConfig.answers.getValue(),
                    areCheatsOn = appConfig.cheats.getValue(),
                    areTipsOn = appConfig.tips.getValue(),
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
        if (viewStateNotifier.value.areTipsOn) setShowMessageEvent(triggered)
        return false
    }

    private fun setShowMessageEvent(state: StateEvent){
        viewStateNotifier.update {
            it.copy(
                showSnackbarEvent = state
            )
        }
    }

    private fun countOfForms():Int{
        var sum = 0
        if (viewStateNotifier.value.isInitialTested) sum += 1
        if (viewStateNotifier.value.isMedialTested) sum += 1
        if (viewStateNotifier.value.isFinalTested) sum += 1
        if (viewStateNotifier.value.isIsolatedTested) sum += 1
        return sum
    }
    override fun setShowMessageConsumed() {
        setShowMessageEvent(consumed)
    }
}
