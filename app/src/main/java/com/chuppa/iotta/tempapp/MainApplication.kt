package com.chuppa.iotta.tempapp

import android.app.Application
import com.chuppa.iotta.tempapp.dependency.appModule
import com.chuppa.iotta.tempapp.dependency.dataModule
import com.chuppa.iotta.tempapp.ui.userListFragmentModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModule + userListFragmentModule)
        }

    }
}

