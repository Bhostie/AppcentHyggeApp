package com.hyggeapp.barisgokmen

import android.app.Application
import android.content.Context

class HyggeApplication : Application() {

    companion object {
        lateinit var context: Context
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}