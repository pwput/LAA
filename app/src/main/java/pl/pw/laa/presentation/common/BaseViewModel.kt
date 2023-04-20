package pl.pw.laa.presentation.common

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.model.appConfigAnswers
import pl.pw.laa.model.appConfigCheats
import pl.pw.laa.model.appConfigTips
import pl.pw.laa.presistence.AppConfigKeyRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(private val repository: AppConfigKeyRepository) : ViewModel() {
    init {
        Timber.d("BaseViewModel init")
    }
    val numbers = repository.getAppConfigKey(appConfigAnswers)

    val cheats = repository.getAppConfigKey(appConfigCheats)

    val tips = repository.getAppConfigKey(appConfigTips)
}
