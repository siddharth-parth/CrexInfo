package com.example.crexinfo.api

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class CrexVolley(context: Context) {

    companion object {
        @Volatile
        private var INSTANCE: CrexVolley? = null

        // returns the instance of Volley
        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: CrexVolley(context).also {
                    INSTANCE = it
                }
            }
    }

    // instance of volley request queue
    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }
}