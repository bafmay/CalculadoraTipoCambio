package com.retobcp.features.exchange_rate.mapper

import com.retobcp.core.domain.model.Exchange
import com.retobcp.features.model.ExchangeModel

class ExchangeRateMapper {
    fun map(item: Exchange) = with(item){
        ExchangeModel(id, countryName,countryISO, exchangeValue, inchangeValue,exchangeCurrency,description)
    }
}