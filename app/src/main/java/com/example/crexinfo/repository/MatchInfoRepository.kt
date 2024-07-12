package com.example.crexinfo.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.example.crexinfo.api.model.MatchInfoNetwork
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MatchInfoRepository(private val requestQueue: RequestQueue) {

    val infoLiveData = MutableLiveData<MatchInfoNetwork>()

    suspend fun fetchData() {
        withContext(Dispatchers.IO) {
            val request = JsonObjectRequest(
                Request.Method.GET,
                "https://cricket-exchange-testing.firebaseio.com/match/info.json",
                null,
                { response ->
                    val gson = Gson()
                    val infoData = gson.fromJson(response.toString(), MatchInfoNetwork::class.java)
                    infoLiveData.postValue(infoData)
                },
                { error ->
                    Log.e("CrexInfo", "API failed due to error: ", error.cause)
                }
            )
            requestQueue.add(request)
        }
    }
}