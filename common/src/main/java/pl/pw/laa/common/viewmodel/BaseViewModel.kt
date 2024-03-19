package pl.pw.laa.common.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel : ViewModel() {
	init {
		Timber.d("BaseViewModel init")
	}

	private val isLoadingNotifier = MutableLiveData(false)
	private val showDialogNotifier = MutableLiveData(false)

	fun isLoading() = isLoadingNotifier.value ?: false

	fun startLoading() {
		Timber.d("BaseViewModel started loading")
		isLoadingNotifier.value = true
	}

	fun stopLoading() {
		Timber.d("BaseViewModel stopped loading")
		isLoadingNotifier.value = false
	}

	fun runInLoading(block: suspend () -> Unit) {
		viewModelScope.launch {
			startLoading()
			block.invoke()
			stopLoading()
		}
	}
}
