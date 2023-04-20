package pl.pw.laa.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pw.laa.presistence.AppConfigKeyRepository
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    ViewModel() {

    init {
    }
}
