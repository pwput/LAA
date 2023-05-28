package pl.pw.laa.menu

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.pw.laa.mediaplayer.BaseAudioViewModel
import pl.pw.laa.menu.domain.AlphabetTable
import pl.pw.laa.menu.domain.MenuItem
import pl.pw.laa.menu.domain.Settings
import pl.pw.laa.menu.domain.Test
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() :
    BaseAudioViewModel() {

    val list: List<MenuItem> = listOf(
        Test,
        AlphabetTable,
        Settings,
    )

    init {
      viewModelScope.launch(context = Dispatchers.IO) {
            //repository.initDb()
        }
    }
}
