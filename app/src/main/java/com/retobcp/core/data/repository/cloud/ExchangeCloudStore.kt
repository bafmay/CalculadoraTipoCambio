package com.retobcp.core.data.repository.cloud

import com.retobcp.core.data.network.RetoBCPApi
import com.retobcp.core.data.repository.cloud.dto.ExchangeDTO
import com.retobcp.core.data.utils.safeApiCall

class ExchangeCloudStore(
    private val retoBCPApi: RetoBCPApi
) {
    suspend fun getExchangeRates(): ExchangeDTO {
        val response = safeApiCall { retoBCPApi.getExchanges() }
        return requireNotNull(response)
    }
}