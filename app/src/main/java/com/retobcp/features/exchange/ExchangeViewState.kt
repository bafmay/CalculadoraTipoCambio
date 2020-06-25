package com.retobcp.features.exchange

import com.retobcp.features.model.ExchangeModel

sealed class ExchangeViewState {
    class Success(val exchange1: ExchangeModel,val exchange2: ExchangeModel): ExchangeViewState()
    class Failure(val message: String) : ExchangeViewState()
}