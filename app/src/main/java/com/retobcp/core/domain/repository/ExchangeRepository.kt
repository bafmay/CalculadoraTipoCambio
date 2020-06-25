package com.retobcp.core.domain.repository

import com.retobcp.core.domain.model.Exchange

interface ExchangeRepository {
    suspend fun syncExchanges()
    suspend fun getExchangeRates(currency: String, currency2: String): List<Exchange>
    suspend fun getExchange(currency: String,currency2: String): List<Exchange>
}