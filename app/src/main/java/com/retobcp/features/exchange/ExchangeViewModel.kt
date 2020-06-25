package com.retobcp.features.exchange

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

class ExchangeViewModel (
    private val exchangeUseCase: ExchangeUseCase,
    private val mapper: ExchangeRateMapper
): ViewModel(){
    val viewState : LiveData<ExchangeViewState> get() = _viewState
    private val _viewState = MutableLiveData<ExchangeViewState>()

    fun getExchange(currency1:String,currency2: String){
        viewModelScope.launch(handler) {
            io {
                val response1 = exchangeUseCase.getCountryExchange(currency1,currency2).map { mapper.map(it) }
                val response2 = exchangeUseCase.getCountryExchange(currency2,currency1).map { mapper.map(it) }
                _viewState.postValue(ExchangeViewState.Success(response1.first(),response2.first()))
            }
        }
    }

    private val handler = CoroutineExceptionHandler {_,exception ->
        ui {
            val message = exception.message.orEmpty()
            _viewState.value = ExchangeViewState.Failure(message)
        }
    }
}