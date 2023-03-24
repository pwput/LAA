package pl.pw.laa.ui.common

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {
    init {
        Timber.d("BaseViewModel init")
    }
}