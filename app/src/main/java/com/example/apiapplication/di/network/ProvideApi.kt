package com.example.apiapplication.di.network


import retrofit2.Retrofit

inline fun <reified Api> provideApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)