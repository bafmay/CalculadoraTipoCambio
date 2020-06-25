package com.retobcp.core.data.repository

import com.retobcp.core.data.repository.cloud.ExchangeCloudStore
import com.retobcp.core.data.repository.data.ExchangeDataStore
import com.retobcp.core.data.repository.mapper.ExchangeMapper
import com.retobcp.core.domain.model.Exchange
import com.retobcp.core.domain.repository.ExchangeRepository

class ExchangeDataRepository (
    private val exchangeCloudStore: ExchangeCloudStore,
    private val exchangeDataStore: ExchangeDataStore,
    private val exchangeMapper: ExchangeMapper
): ExchangeRepository{

    override suspend fun syncExchanges() {
        val response = exchangeCloudStore.getExchangeRates()
        val exchange = response.exchangeItems.map {  exchangeMapper.map(it)}
        exchangeDataStore.saveExchange(exchange)
        val currency = response.currencyItems.map { exchangeMapper.map(it) }
        exchangeDataStore.saveCurrency(currency)
    }

    override suspend fun getExchangeRates(currency: String, currency2: String): List<Exchange> {
        return exchangeDataStore.getExchangesList(currency,currency2).map { exchangeMapper.map(it) }
    }

    override suspend fun getExchange(currency: String,currency2: String): List<Exchange> {
        return exchangeDataStore.getExchange(currency,currency2).map { exchangeMapper.map(it) }
    }
}