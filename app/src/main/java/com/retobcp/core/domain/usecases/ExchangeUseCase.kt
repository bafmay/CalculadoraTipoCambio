package com.retobcp.core.domain.usecases

import com.retobcp.core.domain.model.Exchange
import com.retobcp.core.domain.repository.ExchangeRepository

class ExchangeUseCase (
    private val exchangeRepository: ExchangeRepository
){
    suspend fun syncCurrencies(){
        exchangeRepository.syncExchanges()
    }

    suspend fun getExchanges(currency1: String, currency2: String):List<Exchange>{
        return exchangeRepository.getExchangeRates(currency1,currency2)
    }

    suspend fun getCountryExchange(currency: String,currency2: String): List<Exchange>{
        return exchangeRepository.getExchange(currency,currency2)
    }

}