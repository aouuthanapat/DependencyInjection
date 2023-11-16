package com.example.apiapplication.di

import com.example.apiapplication.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// для создания viewModel

val presentationModule = module {
    viewModel {
        MainActivityViewModel(get())
    }
}
