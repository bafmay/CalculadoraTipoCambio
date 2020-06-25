package com.retobcp.di

import android.app.Application
import com.retobcp.core.data.di.dataModule
import com.retobcp.core.domain.di.domainModule
import com.retobcp.features.di.presentationModule
import com.retobcp.features.utils.listByElementsOf

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

internal fun injectModules(app: Application){
    startKoin {
        androidLogger()
        androidContext(app)
        modules(baseModule)
    }
}

internal val baseModule by lazy {
    listByElementsOf<Module>(
        presentationModule,
        domainModule,
        dataModule
    )
}