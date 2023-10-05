package pl.pw.laa.viewmodel

import kotlinx.coroutines.flow.StateFlow
import pl.pw.laa.state.BaseState

interface IStateViewModel {
    val viewState: StateFlow<BaseState>
}