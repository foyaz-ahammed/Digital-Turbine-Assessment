package com.digitalturbine.assessment

import android.app.Application
import com.digitalturbine.assessment.module.networkModule
import com.digitalturbine.assessment.module.repositoryModule
import org.koin.core.context.startKoin

class AdsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(networkModule, repositoryModule)
        }
    }
}