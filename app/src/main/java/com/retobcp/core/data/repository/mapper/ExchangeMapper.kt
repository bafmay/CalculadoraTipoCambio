package com.retobcp.core.data.repository.mapper

import com.retobcp.core.data.entity.CurrencyEntity
import com.retobcp.core.data.entity.ExchangeEntity
import com.retobcp.core.data.entity.ExchangeJoinned
import com.retobcp.core.data.repository.cloud.dto.ExchangeDTO
import com.retobcp.core.domain.model.Exchange

class ExchangeMapper {

    fun map(item : ExchangeDTO.ExchangeItemDTO) = with(item){
        ExchangeEntity(id,countryName, countryISO, exchangeCurrency,description)
    }

    fun map(item : ExchangeDTO.CurrencyItemDTO) = with(item){
        CurrencyEntity(id, originCurrency, destCurrency, exchangeCurrency, inchangeCurrency)
    }

    fun map(item: ExchangeJoinned) = with(item){
        Exchange(id,countryName,countryISO,exchangeCurrencyValue,inchangeCurrencyValue,exchangeCurrency, description)
    }

}