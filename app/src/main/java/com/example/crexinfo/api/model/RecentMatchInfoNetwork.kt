package com.example.crexinfo.api.model

import com.google.gson.annotations.SerializedName

data class RecentMatchInfoNetwork(
    @SerializedName("match_no")
    val matchNumber: String,
    @SerializedName("team1")
    val teamOne: String,
    @SerializedName("team1_overs")
    val teamOneOvers: String,
    @SerializedName("team1_score")
    val teamOneScore: String,
    @SerializedName("team2")
    val teamTwo: String,
    @SerializedName("team2_overs")
    val teamTwoOvers: String,
    @SerializedName("team2_score")
    val teamTwoScore: String,
)