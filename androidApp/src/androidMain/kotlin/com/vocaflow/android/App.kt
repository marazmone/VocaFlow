package com.vocaflow.android

import android.app.Application
import di.initKoin
import org.koin.android.BuildConfig.DEBUG
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level.ERROR
import org.koin.core.logger.Level.NONE

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(level = if (DEBUG) ERROR else NONE)
            androidContext(androidContext = this@App)
        }
    }
}
