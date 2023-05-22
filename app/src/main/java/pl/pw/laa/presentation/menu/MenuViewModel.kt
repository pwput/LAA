package pl.pw.laa.presentation.menu

import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.data.presistence.AppConfigKeyRepository
import pl.pw.laa.presentation.mediaplayer.BaseAudioViewModel
import pl.pw.laa.presentation.menu.domain.AlphabetTable
import pl.pw.laa.presentation.menu.domain.MenuItem
import pl.pw.laa.presentation.menu.domain.Settings
import pl.pw.laa.presentation.menu.domain.Test
import pl.pw.laa.presentation.menu.domain.Vocalization
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseAudioViewModel() {

    val list: List<MenuItem> = listOf(
        Test,
        AlphabetTable,
        Vocalization,
        Settings,
    )

    init {
/*        viewModelScope.launch(context = Dispatchers.IO) {
            repository.initDb()
        }*/
    }
}
