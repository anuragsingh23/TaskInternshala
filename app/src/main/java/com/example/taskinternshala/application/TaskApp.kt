package com.example.taskinternshala.application

import android.app.Application
import com.example.taskinternshala.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class TaskApp : Application() {

    companion object {
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        startKoin {
            androidContext(instance)
            modules(applicationModule)
        }

    }
}