package com.digitalturbine.assessment

import android.app.Application
import org.koin.core.context.startKoin

class AdsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
        }
    }
}