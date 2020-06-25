package com.retobcp.core.data.repository.di

import com.retobcp.core.data.db.AppDatabase
import com.retobcp.core.data.repository.ExchangeDataRepository
import com.retobcp.core.data.repository.cloud.ExchangeCloudStore
import com.retobcp.core.data.repository.data.ExchangeDataStore
import com.retobcp.core.data.repository.mapper.ExchangeMapper
import com.retobcp.core.domain.repository.ExchangeRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    factory { ExchangeMapper() }
    factory { ExchangeCloudStore(get()) }
    factory { ExchangeDataStore(get(),get()) }
    factory<ExchangeRepository> { ExchangeDataRepository(get(),get(),get()) }
}

internal val dataBaseModule = module {
    single { AppDatabase.getInstance(get()) }
    single { get<AppDatabase>().exchangeDao() }
    single { get<AppDatabase>().currencyDao() }
}