package com.digitalturbine.assessment

import android.app.Application
import com.digitalturbine.assessment.module.networkModule
import com.digitalturbine.assessment.module.repositoryModule
import com.digitalturbine.assessment.module.viewModelModule
import org.koin.core.context.startKoin

/**
 * Application class used on the app
 */
class AdsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Start koin modules
        startKoin {
            modules(networkModule, repositoryModule, viewModelModule)
        }
    }
}