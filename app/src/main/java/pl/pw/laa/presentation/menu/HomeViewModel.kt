package pl.pw.laa.presentation.menu

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import pl.pw.laa.data.Alphabet

import pl.pw.laa.viewmodel.BaseViewModel
import pl.pw.laa.viewmodel.ISnackbarViewModel
import pl.pw.laa.viewmodel.IStateViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeViewModel @Inject constructor() :
    BaseViewModel(), IStateViewModel{
    private val viewStateNotifier = MutableStateFlow(HomeState())
    override val viewState = viewStateNotifier.asStateFlow()

    init {
        val newId = Random.nextInt(Alphabet.letters.size)
        viewStateNotifier.value = viewStateNotifier.value.copy(letterId = newId)
    }
}
