package com.retobcp.core.data.repository.cloud.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeDTO (
    @SerializedName("exchange")
    val exchangeItems : List<ExchangeItemDTO>,
    @SerializedName("currency")
    val currencyItems : List<CurrencyItemDTO>

){

    @Serializable
    data class ExchangeItemDTO(
        @SerialName("id")
        val id: String,

        @SerialName("countryName")
        val countryName: String?,

        @SerialName("countryISO")
        val countryISO: String?,

        @SerialName("exchangeCurrency")
        val exchangeCurrency: String?,

        @SerialName("description")
        val description: String?
    )

    @Serializable
    data class CurrencyItemDTO(
        @SerialName("id")
        val id: String,

        @SerialName("originCurrency")
        val originCurrency: String?,

        @SerialName("destCurrency")
        val destCurrency: String?,

        @SerialName("exchangeCurrency")
        val exchangeCurrency: Double?,

        @SerialName("inchangeCurrency")
        val inchangeCurrency: Double?
    )
}