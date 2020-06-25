package com.retobcp.core.data.di

import com.retobcp.core.data.network.di.networkModule
import com.retobcp.core.data.repository.di.dataBaseModule
import com.retobcp.core.data.repository.di.repositoryModule
import com.retobcp.features.utils.listByElementsOf
import org.koin.core.module.Module

internal val dataModule by lazy{
    listByElementsOf<Module>(
        networkModule,
        repositoryModule,
        dataBaseModule
    )
}