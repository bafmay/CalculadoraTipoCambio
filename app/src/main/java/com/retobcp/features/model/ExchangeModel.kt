package com.retobcp.features.model

import java.io.Serializable

data class ExchangeModel(
    val id:String,
    val countryName:String,
    val countryISO: String,
    val exchangeValue: Double,
    val inchangeValue: Double,
    val exchangeCurrency:String,
    val description: String
) : Serializable