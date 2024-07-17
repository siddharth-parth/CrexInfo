package com.example.crexinfo

import android.app.Application
import com.example.crexinfo.api.CrexVolley
import com.google.firebase.FirebaseApp

class CrexInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        CrexVolley.getInstance(applicationContext)
        FirebaseApp.initializeApp(this)
    }
}