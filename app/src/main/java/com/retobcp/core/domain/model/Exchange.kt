package com.retobcp.core.domain.model

class Exchange(
    val id:String,
    val countryName:String,
    val countryISO: String,
    val exchangeValue: Double,
    val inchangeValue: Double,
    val exchangeCurrency:String,
    val description:String
)