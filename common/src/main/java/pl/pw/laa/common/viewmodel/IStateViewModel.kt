package pl.pw.laa.common.viewmodel

import kotlinx.coroutines.flow.StateFlow
import pl.pw.laa.common.state.BaseState

interface IStateViewModel {
	val viewState: StateFlow<BaseState>
}