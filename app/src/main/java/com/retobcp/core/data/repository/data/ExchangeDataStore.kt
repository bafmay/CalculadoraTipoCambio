package com.retobcp.core.data.repository.data

import com.retobcp.core.data.entity.CurrencyEntity
import com.retobcp.core.data.entity.ExchangeEntity
import com.retobcp.core.data.entity.ExchangeJoinned

class ExchangeDataStore (
    private val exchangeDao: ExchangeDao,
    private val currencyDao: CurrencyDao
){
    fun saveExchange(items: List<ExchangeEntity>){
        exchangeDao.deleteAll()
        exchangeDao.insertAll(items)
    }

    fun saveCurrency(items: List<CurrencyEntity>){
        currencyDao.deleteAll()
        currencyDao.insertAll(items)
    }

    fun getExchangesList(currency: String, currency2: String):List<ExchangeJoinned>{
        return exchangeDao.getExchangesList(currency,currency2)
    }

    fun getExchange(currency:String,currency2:String):List<ExchangeJoinned>{
        return exchangeDao.getExchange(currency,currency2)
    }
}