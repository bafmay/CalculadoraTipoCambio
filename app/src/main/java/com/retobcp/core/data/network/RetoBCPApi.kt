package com.retobcp.core.data.network

import com.retobcp.core.data.repository.cloud.dto.ExchangeDTO
import retrofit2.Response
import retrofit2.http.GET

interface RetoBCPApi {

    @GET("exchanges")
    suspend fun getExchanges(): Response<List<ExchangeDTO>>
}