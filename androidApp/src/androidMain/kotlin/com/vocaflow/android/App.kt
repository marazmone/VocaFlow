package com.vocaflow.android

import android.app.Application
import data.datasource.firebase.core.crashlytics.FirebaseCrashlyticsLogger
import di.initKoin
import org.koin.android.BuildConfig.DEBUG
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level.ERROR
import org.koin.core.logger.Level.NONE
import presentation.text.Strings

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initStrings()
        initKoin {
            androidLogger(level = if (DEBUG) ERROR else NONE)
            androidContext(androidContext = this@App)
        }
    }

    // This is workaround resolving the issue with the context not being available in the shared module
    private fun initStrings() {
        Strings.context = this
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            FirebaseCrashlyticsLogger.initDebugBuild()
        } else {
            FirebaseCrashlyticsLogger.initReleaseBuild()
        }
    }
}
