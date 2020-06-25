package com.retobcp.core.domain.di

import com.retobcp.core.domain.usecases.ExchangeUseCase
import com.retobcp.features.utils.listByElementsOf
import org.koin.core.module.Module
import org.koin.dsl.module

internal val domainModule by lazy {
    listByElementsOf<Module>(
        useCaseModule
    )
}

internal val useCaseModule = module {
    factory { ExchangeUseCase(get()) }
}