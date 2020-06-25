package com.retobcp.features.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retobcp.core.domain.usecases.ExchangeUseCase
import com.retobcp.features.utils.io
import com.retobcp.features.utils.ui
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class SplashViewModel(
    private val exchangeUseCase: ExchangeUseCase
) : ViewModel() {

    val viewState: LiveData<SplashViewState> get() = _viewState
    private val _viewState = MutableLiveData<SplashViewState>()

    fun syncCurrencies() {
        viewModelScope.launch(handler) {
            io {
                exchangeUseCase.syncCurrencies()
                _viewState.postValue(SplashViewState.Success)
            }
        }
    }

    private val handler = CoroutineExceptionHandler { _, exception ->
        ui {
            val message = exception.message.orEmpty()
            _viewState.value = SplashViewState.Failure(message)
        }
    }

}