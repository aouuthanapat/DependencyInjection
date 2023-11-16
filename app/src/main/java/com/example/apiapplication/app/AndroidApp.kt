package com.example.apiapplication.app

import android.app.Application
import com.example.apiapplication.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
    }

    private fun startKoin() = startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@AndroidApp)
        modules(appModule)
    }
}