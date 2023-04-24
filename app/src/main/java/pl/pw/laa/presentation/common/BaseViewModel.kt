package pl.pw.laa.presentation.common

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.data.model.appConfigAnswers
import pl.pw.laa.data.model.appConfigCheats
import pl.pw.laa.data.model.appConfigTips
import pl.pw.laa.data.presistence.AppConfigKeyRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(repository: AppConfigKeyRepository) : ViewModel() {
    init {
        Timber.d("BaseViewModel init")
    }

    val numberOfPossibleAnswers = repository.getAppConfigKey(appConfigAnswers)

    val areCheatsOn = repository.getAppConfigKey(appConfigCheats)

    val areTipsOn = repository.getAppConfigKey(appConfigTips)
}
