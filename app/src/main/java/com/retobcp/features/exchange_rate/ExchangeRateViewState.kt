package com.retobcp.features.exchange_rate

import com.retobcp.features.model.ExchangeModel

sealed class ExchangeRateViewState {
    class Success(val items: List<ExchangeModel>): ExchangeRateViewState()
    class Failure(val message: String) : ExchangeRateViewState()
}