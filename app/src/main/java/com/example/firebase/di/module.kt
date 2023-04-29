package com.example.firebase.di

import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
//    viewModel { TestViewModel() }
    single { FirebaseAuth.getInstance() }
}