package com.example.crexinfo

import android.app.Application
import com.example.crexinfo.api.CrexVolley

class CrexInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        CrexVolley.getInstance(applicationContext)
    }
}