package com.retobcp.di

import android.content.Context
import com.retobcp.core.data.db.AppDatabase
import com.retobcp.core.data.di.dataModule
import com.retobcp.core.data.network.RetoBCPApi
import com.retobcp.core.data.repository.data.CurrencyDao
import com.retobcp.core.data.repository.data.ExchangeDao
import com.retobcp.core.domain.di.domainModule
import com.retobcp.features.di.presentationModule
import com.retobcp.features.utils.listByElementsOf
import io.mockk.mockk
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

internal fun injectDependenciesTestModules() {
    startKoin {
        printLogger()
        modules(baseDependenciesTestModules)
    }
}

private val baseDependenciesTestModules by lazy {
    listByElementsOf<Module>(
        dataModule,
        domainModule,
        presentationModule,
        baseDependenciesMocksModule
    )
}

private val baseDependenciesMocksModule = module {
    factory(override = true) { mockk<Context>() }
    factory(override = true) { mockk<RetoBCPApi>() }
    factory(override = true) { mockk<AppDatabase>() }
    single(override = true) { mockk<ExchangeDao>() }
    single(override = true) { mockk<CurrencyDao>() }
}