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
import pl.pw.laa.viewmodel.BaseViewModel
import pl.pw.laa.viewmodel.IStateViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferencesRepository: IUserPreferencesRepository
) : BaseViewModel(), IStateViewModel {

    private val viewStateNotifier = MutableStateFlow(SettingsState())
    override val viewState = viewStateNotifier.asStateFlow()

    init {
        runInLoading {
            loadUserPreferences()
        }
    }

    private suspend fun loadUserPreferences() {
        val preferences = userPreferencesRepository.userPreferencesFlow
        viewStateNotifier.update {
            it.copy(
                answersCount = preferences.first().answersCount,
                areCheatsEnabled = preferences.first().areCheatsEnabled,
                areTipsEnabled = preferences.first().areTipsEnabled,
                isInitialTested = preferences.first().isInitial,
                isMedialTested = preferences.first().isMedial,
                isFinalTested = preferences.first().isFinal,
                isIsolatedTested = preferences.first().isIsolated,
            )
        }
    }

    fun onEvent(event: SettingsEvent) {
        viewModelScope.launch(context = Dispatchers.IO) {
            Timber.d("SettingsEvent: ${event::class.simpleName}, value: '${event.value}'.")
            when (event) {
                is SettingsEvent.SetAnswersCount ->
                    userPreferencesRepository.updateAnswersCount(event.value)
                is SettingsEvent.SetAreCheatsOn ->
                    userPreferencesRepository.updateAreCheatsEnabled(event.value)
                is SettingsEvent.SetAreTipsOn ->
                    userPreferencesRepository.updateAreTipsEnabled(event.value)
                is SettingsEvent.SettingsEventForm ->
                    onFormEvent(event)
                else ->
                    Timber.d("Unknown event: ${event::class.simpleName}")
            }
            loadUserPreferences()
        }
    }

    private suspend fun onFormEvent(event: SettingsEvent.SettingsEventForm) {
        if (canFormBeChanged(event.value)) {
            when(event){
                is SettingsEvent.SetIsFinalTested ->
                    userPreferencesRepository.updateIsFinalTested(event.value)
                is SettingsEvent.SetIsInitialTested ->
                    userPreferencesRepository.updateIsInitialTested(event.value)
                is SettingsEvent.SetIsIsolatedTested ->
                    userPreferencesRepository.updateIsIsolatedTested(event.value)
                is SettingsEvent.SetIsMedialTested ->
                    userPreferencesRepository.updateIsMedialTested(event.value)
            }
        }
    }

    private fun canFormBeChanged(newValue: Boolean): Boolean {
        if (newValue) return true
        if (viewStateNotifier.value.formCount() > 1) return true
        if (viewStateNotifier.value.areTipsEnabled) setShowMessageEvent(triggered)
        Timber.d("Can't change form")
        return false
    }

    private fun setShowMessageEvent(state: StateEvent) {
        viewStateNotifier.update {
            it.copy(
                showSnackbarEvent = state
            )
        }
    }

    override fun setShowMessageConsumed() {
        setShowMessageEvent(consumed)
    }
}
