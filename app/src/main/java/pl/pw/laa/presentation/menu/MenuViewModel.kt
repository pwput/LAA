package pl.pw.laa.presentation.menu

import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.mediaplayer.BaseAudioViewModel
import pl.pw.laa.presentation.menu.domain.AlphabetTable
import pl.pw.laa.presentation.menu.domain.MenuItem
import pl.pw.laa.presentation.menu.domain.Settings
import pl.pw.laa.presentation.menu.domain.Test
import pl.pw.laa.presentation.menu.domain.Vocalization
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() :
    BaseAudioViewModel() {

    val list: List<MenuItem> = listOf(
        Test,
        AlphabetTable,
        Vocalization,
        Settings,
    )
}
