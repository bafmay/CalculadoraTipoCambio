package com.retobcp.features.exchange_rate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retobcp.core.domain.usecases.ExchangeUseCase
import com.retobcp.features.exchange_rate.mapper.ExchangeRateMapper
import com.retobcp.features.utils.io
import com.retobcp.features.utils.ui
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ExchangeRateViewModel (
    private val exchangeUseCase: ExchangeUseCase,
    private val mapper: ExchangeRateMapper
): ViewModel(){

    val viewState : LiveData<ExchangeRateViewState> get() = _viewState
    private val _viewState = MutableLiveData<ExchangeRateViewState>()

    fun getExchange(currency1:String,currency2:String){
        viewModelScope.launch(handler) {
            io {
                val response = exchangeUseCase.getExchanges(currency1,currency2).map { mapper.map(it) }
                _viewState.postValue(ExchangeRateViewState.Success(response))
            }
        }
    }

    private val handler = CoroutineExceptionHandler {_,exception ->
        ui {
            val message = exception.message.orEmpty()
            _viewState.value = ExchangeRateViewState.Failure(message)
        }
    }

}