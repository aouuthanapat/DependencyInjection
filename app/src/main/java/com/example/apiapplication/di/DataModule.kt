package com.example.apiapplication.di

import com.example.apiapplication.RequestManager
import com.example.apiapplication.di.network.provideApi
import org.koin.dsl.module

val dataModule = module {
    single<RequestManager.NewsApiService> {
        provideApi(retrofit = get())
    }
}
