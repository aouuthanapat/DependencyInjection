package com.example.apiapplication.di

import com.example.apiapplication.di.network.serversModule
import org.koin.core.module.Module

val appModule: List<Module> = dataModule + presentationModule + domainModule + serversModule