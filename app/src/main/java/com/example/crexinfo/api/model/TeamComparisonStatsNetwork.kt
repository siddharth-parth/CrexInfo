package com.example.crexinfo.api.model

import com.google.gson.annotations.SerializedName

data class TeamComparisonStatsNetwork(
    @SerializedName("avg_score")
    val avgScore: Float,
    @SerializedName("highest_score")
    val highestScore: Int,
    @SerializedName("lowest_score")
    val lowestScore: Int,
    @SerializedName("matches")
    val matches: Int,
    @SerializedName("team_name")
    val teamName: String,
    @SerializedName("won")
    val won: Int,
)