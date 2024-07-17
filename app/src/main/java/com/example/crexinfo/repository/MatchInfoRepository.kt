package com.example.crexinfo.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.example.crexinfo.api.model.MatchInfoNetwork
import com.example.crexinfo.helper.ViewDataConverter
import com.example.crexinfo.model.viewdatas.MatchInfoViewData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MatchInfoRepository(private val requestQueue: RequestQueue) {

    val infoLiveData = MutableLiveData<MatchInfoViewData>()

    companion object {
        private const val MATCH_INFO_REF = "match_info"
    }

    suspend fun fetchData() {
        withContext(Dispatchers.IO) {
            val request = JsonObjectRequest(
                Request.Method.GET,
                "https://cricket-exchange-testing.firebaseio.com/match/info.json",
                null,
                { response ->
                    val gson = Gson()
                    val infoData = gson.fromJson(response.toString(), MatchInfoNetwork::class.java)
                    infoLiveData.postValue(ViewDataConverter.convertMatchInfo(infoData))
                },
                { error ->
                    Log.e("CrexInfo", "API failed due to error: ", error.cause)
                }
            )
            requestQueue.add(request)
        }
    }

    suspend fun fetchDataFromFirebase() {
        withContext(Dispatchers.IO) {
            try {
                val rootRef: DatabaseReference = FirebaseDatabase.getInstance().reference
                val matchInfoRef: DatabaseReference = rootRef.child(MATCH_INFO_REF)
                matchInfoRef.get().addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val result = task.result
                        result?.let {
                            val gson = Gson()
                            val jsonObject = gson.toJsonTree(result.value).asJsonObject
                            val jsonString = gson.toJson(jsonObject)
                            val person = gson.fromJson(jsonString, MatchInfoNetwork::class.java)
                            infoLiveData.postValue(ViewDataConverter.convertMatchInfo(person))
                        }
                    } else {
                        Log.e("CrexInfo", "Fetching data failed due to ${task.exception?.message}")
                    }
                }
            } catch (exception: Exception) {
                Log.e("CrexInfo", "Fetching data failed due to: ${exception.message}")
            }
        }
    }
}