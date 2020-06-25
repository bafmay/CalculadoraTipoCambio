package com.retobcp.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.retobcp.core.data.entity.ExchangeJoinned
import com.retobcp.core.data.repository.cloud.dto.ExchangeDTO
import com.retobcp.utils.readString
import java.lang.reflect.Type

object ExchangeMockHelper {

    private fun fetchExchange(): ExchangeDTO {
        val jsonString = readString("data/exchanges.json")
        val gson = Gson()
        val listType: Type = object : TypeToken<ExchangeDTO?>() {}.type
        return gson.fromJson(jsonString, listType)
    }

    fun getItems(currency1: String, currency2: String): List<ExchangeJoinned> {
        val items = mutableListOf<ExchangeJoinned>()
        val currency =
            fetchExchange().currencyItems.filter { it.originCurrency == currency1 && it.destCurrency != currency2 }
        for (item in currency) {
            val country =
                fetchExchange().exchangeItems.first { item.destCurrency == it.exchangeCurrency }
            items.add(
                ExchangeJoinned(
                    item.id,
                    country.countryName.orEmpty(),
                    country.countryISO.orEmpty(),
                    item.exchangeCurrency ?: 0.0,
                    item.inchangeCurrency ?: 0.0,
                    country.exchangeCurrency.orEmpty(),
                    country.description.orEmpty()
                )
            )
        }
        return items

    }

    fun getCurrencyItem(currency1: String, currency2: String): List<ExchangeJoinned> {
        val items = mutableListOf<ExchangeJoinned>()
        val currency =
            fetchExchange().currencyItems.filter { it.originCurrency == currency1 && it.destCurrency == currency2 }
        for (item in currency) {
            val country =
                fetchExchange().exchangeItems.first { item.originCurrency == it.exchangeCurrency }
            items.add(
                ExchangeJoinned(
                    item.id,
                    country.countryName.orEmpty(),
                    country.countryISO.orEmpty(),
                    item.exchangeCurrency ?: 0.0,
                    item.inchangeCurrency ?: 0.0,
                    country.exchangeCurrency.orEmpty(),
                    country.description.orEmpty()
                )
            )
        }
        return items

    }

}