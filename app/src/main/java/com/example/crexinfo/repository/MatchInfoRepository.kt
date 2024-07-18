package com.example.crexinfo.repository

import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.example.crexinfo.api.model.MatchInfoNetwork
import com.example.crexinfo.helper.ViewDataConverter
import com.example.crexinfo.model.viewdatas.MatchInfoViewData
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class MatchInfoRepository(private val requestQueue: RequestQueue) {

    companion object {
        private const val MATCH_INFO_REF = "match_info"
    }

    // calls the API to fetch match info and returns a flow with the data
    fun fetchData(): Flow<MatchInfoViewData> {
        return callbackFlow {
            // json request to fetch match info
            val request = JsonObjectRequest(
                Request.Method.GET,
                "https://cricket-exchange-testing.firebaseio.com/match/info.json",
                null,
                { response ->
                    val gson = Gson()
                    val infoData = gson.fromJson(response.toString(), MatchInfoNetwork::class.java)
                    trySend(ViewDataConverter.convertMatchInfo(infoData))
                },
                { error ->
                    // logs the error in case of API failure
                    Log.e("CrexInfo", "API failed due to error: ", error.cause)
                }
            )
            requestQueue.add(request)
            awaitClose { }
        }
    }

    // gets the match info data from FirebaseDatabase and returns a flow with the data
    fun fetchDataFromFirebase(): Flow<MatchInfoViewData> {
        return callbackFlow {
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
                            trySend(ViewDataConverter.convertMatchInfo(person))
                        }
                    } else {
                        // logs the error in case the firebase task fails
                        Log.e("CrexInfo", "Fetching data failed due to ${task.exception?.message}")
                    }
                }
            } catch (exception: Exception) {
                // logs the error in case of error while adding the firebase listener
                Log.e("CrexInfo", "Fetching data failed due to: ${exception.message}")
            }
            awaitClose { }
        }
    }
}