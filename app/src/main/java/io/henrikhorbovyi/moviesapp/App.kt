package io.henrikhorbovyi.moviesapp

import android.app.Application
import io.henrikhorbovyi.data.di.dataModule
import io.henrikhorbovyi.moviesapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        koinSetup()
    }

    private fun koinSetup() {
        startKoin {
            androidContext(this@App)
            modules(appModule, dataModule)
        }
    }
}
