package pl.pw.laa

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {
    init {
        Timber.d("BaseViewModel init")
    }

    var isLoading by mutableStateOf(false)

    fun startLoading() {
        Timber.d("BaseViewModel started loading")
        isLoading = true
    }

    fun stopLoading() {
        Timber.d("BaseViewModel stopped loading")
        isLoading = false
    }
}
