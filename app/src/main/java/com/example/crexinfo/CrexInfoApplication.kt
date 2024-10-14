package com.example.crexinfo

import android.app.Application
import com.example.crexinfo.api.CrexVolley
import com.google.firebase.FirebaseApp

class CrexInfoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // initializes the volley to be used throughout the app lifecycle
        CrexVolley.getInstance(applicationContext)

        //initializes the firebase app
        FirebaseApp.initializeApp(this)
    }
}
