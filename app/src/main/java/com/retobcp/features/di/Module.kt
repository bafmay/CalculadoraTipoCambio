package com.retobcp.features.di

import com.retobcp.features.exchange.ExchangeViewModel
import com.retobcp.features.exchange_rate.ExchangeRateViewModel
import com.retobcp.features.exchange_rate.mapper.ExchangeRateMapper
import com.retobcp.features.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val presentationModule = module {
    factory { ExchangeRateMapper() }

    viewModel { SplashViewModel(get())  }
    viewModel { ExchangeRateViewModel(get(),get())  }
    viewModel { ExchangeViewModel(get(),get())  }
}