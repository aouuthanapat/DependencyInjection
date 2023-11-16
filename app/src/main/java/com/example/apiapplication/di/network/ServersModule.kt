package com.example.apiapplication.di.network

import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

// для создания API RETROFIT
const val BASE_URL = "https://newsapi.org/v2/"
internal val serversModule = module {
    single {
        provideRetrofit()
    }
}

private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(createGsonFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
}

private fun createGsonFactory(): GsonConverterFactory {
    val gson = GsonBuilder()
            .setLenient()
            .create()
    return GsonConverterFactory.create(gson)
}