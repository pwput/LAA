package pl.pw.laa.presentation.settings


import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.palm.composestateevents.StateEvent
import de.palm.composestateevents.consumed
import de.palm.composestateevents.triggered
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.pw.laa.data.repository.IUserPreferencesRepository
import pl.pw.laa.data.repository.UserPreferencesRepository
import pl.pw.laa.viewmodel.BaseViewModel
import pl.pw.laa.viewmodel.IStateViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferencesRepository: IUserPreferencesRepository
) : BaseViewModel(), IStateViewModel{

    private val  viewStateNotifier = MutableStateFlow(SettingsState())
    override val viewState = viewStateNotifier.asStateFlow()
    init {
        startLoading()
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val preferences = userPreferencesRepository.userPreferencesFlow

            viewStateNotifier.update {
                it.copy(
                    numberOfAnswers = preferences.first().answersCount,
                    areCheatsOn = preferences.first().areCheatsEnabled,
                    areTipsOn = preferences.first().areTipsEnabled,
                    isInitialTested = preferences.first().isInitial,
                    isMedialTested = preferences.first().isMedial,
                    isFinalTested = preferences.first().isFinal,
                    isIsolatedTested = preferences.first().isIsolated,
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
                    userPreferencesRepository.updateAnswersCount(event.answersCount)
                    fetchData()
                }

            is SettingsEvent.SetAreCheatsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting cheets to ${event.areCheatsOn}")
                    userPreferencesRepository.updateAreCheatsEnabled(event.areCheatsOn)
                    fetchData()
                }

            is SettingsEvent.SetAreTipsOn ->
                viewModelScope.launch(context = Dispatchers.IO) {
                    Timber.d("Setting tips to ${event.areTipsOn}")
                    userPreferencesRepository.updateAreTipsEnabled(event.areTipsOn)
                    fetchData()
                }

            is SettingsEvent.SetisFinalTested ->
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsFinalTested to ${event.isForm}")
                        userPreferencesRepository.updateIsFinal(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisInitialTested ->
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsInitialTested to ${event.isForm}")
                        userPreferencesRepository.updateIsInitial(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisIsolatedTested ->
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsIsolatedTested to ${event.isForm}")
                        userPreferencesRepository.updateIsIsolated(event.isForm)
                        fetchData()
                    }

            is SettingsEvent.SetisMedialTested ->
                if (canFormBeChanged(event.isForm))
                    viewModelScope.launch(context = Dispatchers.IO) {
                        Timber.d("Setting appConfigIsMedialTested to ${event.isForm}")
                        userPreferencesRepository.updateIsMedial(event.isForm)
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
