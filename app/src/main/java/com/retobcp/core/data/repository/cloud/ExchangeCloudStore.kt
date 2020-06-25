package com.retobcp.core.data.repository.cloud

import com.retobcp.core.data.network.RetoBCPApi
import com.retobcp.core.data.repository.cloud.dto.ExchangeDTO
import com.retobcp.core.data.utils.safeApiCall

class ExchangeCloudStore(
    private val retoBCPApi: RetoBCPApi
) {
    suspend fun getExchangeRates(): ExchangeDTO {
        //val response = safeApiCall { retoBCPApi.getExchanges() }
        val exchange = listOf(
            ExchangeDTO.ExchangeItemDTO("1", "Peru", "PER", "PEN", "Soles"),
            ExchangeDTO.ExchangeItemDTO("2", "United States", "EU", "USD", "Dolares"),
            ExchangeDTO.ExchangeItemDTO("3", "Union Europea", "UE", "EUR", "Euros"),
            ExchangeDTO.ExchangeItemDTO("4", "China", "CHI", "YEN", "Yenes")
        )
        val currency = listOf(
            ExchangeDTO.CurrencyItemDTO("1", "PEN", "USD", 3.25, 3.4),
            ExchangeDTO.CurrencyItemDTO("2", "PEN", "EUR", 4.25, 2.4),
            ExchangeDTO.CurrencyItemDTO("3", "PEN", "YEN", 5.25, 5.4),
            ExchangeDTO.CurrencyItemDTO("4", "USD", "PEN", 1.25, 4.4),
            ExchangeDTO.CurrencyItemDTO("5", "USD", "EUR", 2.25, 5.4),
            ExchangeDTO.CurrencyItemDTO("6", "USD", "YEN", 3.25, 6.4),
            ExchangeDTO.CurrencyItemDTO("7", "EUR", "PEN", 6.25, 9.4),
            ExchangeDTO.CurrencyItemDTO("8", "EUR", "USD", 7.25, 10.4),
            ExchangeDTO.CurrencyItemDTO("9", "EUR", "YEN", 8.25, 11.4),
            ExchangeDTO.CurrencyItemDTO("10", "YEN", "PEN", 9.25, 12.4),
            ExchangeDTO.CurrencyItemDTO("11", "YEN", "USD", 10.25, 13.4),
            ExchangeDTO.CurrencyItemDTO("12", "YEN", "EUR", 11.25, 14.4)
        )
        val response = ExchangeDTO(exchange, currency)
        return requireNotNull(response)
    }
}