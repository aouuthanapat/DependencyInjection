package com.example.apiapplication.di

import com.example.apiapplication.RequestManager
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val domainModule = module {
    factory {
        RequestManager(androidApplication(), get())
    }
}
