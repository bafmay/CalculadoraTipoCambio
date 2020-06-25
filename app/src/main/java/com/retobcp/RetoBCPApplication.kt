package com.retobcp

import android.app.Application
import com.retobcp.di.injectModules

class RetoBCPApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        injectKoinModules()
    }

    private fun injectKoinModules() {
        injectModules(this)
    }
}