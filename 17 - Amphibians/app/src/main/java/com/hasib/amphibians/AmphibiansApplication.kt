package com.hasib.amphibians

import android.app.Application
import com.hasib.amphibians.data.AppContainer
import com.hasib.amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container : AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}