package pl.pw.laa.presentation.alphabet

import dagger.hilt.android.lifecycle.HiltViewModel
import pl.pw.laa.presentation.common.BaseViewModel
import pl.pw.laa.presistence.AppConfigKeyRepository
import javax.inject.Inject

@HiltViewModel
class AlphabetTableViewModel @Inject constructor(repository: AppConfigKeyRepository) :
    BaseViewModel(repository)
