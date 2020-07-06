package com.retobcp.presentation.dependencies

import com.retobcp.base.BaseDependenciesTest
import com.retobcp.features.exchange.ExchangeViewModel
import com.retobcp.features.exchange_rate.ExchangeRateViewModel
import com.retobcp.features.splash.SplashViewModel
import org.amshove.kluent.shouldNotBeNull
import org.junit.Test
import org.koin.core.get

class ViewModelsDependenciesTest : BaseDependenciesTest(){

    @Test
    fun `resolver dependencies for SplashViewModel`() {
        get<SplashViewModel>().shouldNotBeNull()
    }

    @Test
    fun `resolver dependencies for ExchangeRateViewModel`() {
        get<ExchangeRateViewModel>().shouldNotBeNull()
    }

    @Test
    fun `resolver dependencies for ExchangeViewModel`() {
        get<ExchangeViewModel>().shouldNotBeNull()
    }


}