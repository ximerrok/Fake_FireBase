package com.example.firebase

import android.app.Application
import com.example.firebase.di.module
import org.koin.core.context.startKoin

class DummyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(module))
        }
    }

}