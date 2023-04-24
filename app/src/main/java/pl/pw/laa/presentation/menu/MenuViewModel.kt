package pl.pw.laa.presentation.menu

import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.presentation.mediaplayer.BaseAudioViewModel
import pl.pw.laa.presistence.AppConfigKeyRepository
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseAudioViewModel(repository) {

    val list: List<MenuItem> = listOf(
        Test,
        AlphabetTable,
        Vocalization,
        Settings,
    )
}
