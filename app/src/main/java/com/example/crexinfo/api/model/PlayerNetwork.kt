package com.example.crexinfo.api.model

import com.google.gson.annotations.SerializedName

data class PlayerNetwork(
    @SerializedName("is_captain")
    val isCaptain: Boolean,
    @SerializedName("is_wicketkeeper")
    val isWicketKeeper: Boolean,
    @SerializedName("player_key")
    val playerKey: String,
    @SerializedName("player_name")
    val playerName: String,
    @SerializedName("role")
    val role: String,
    @SerializedName("team_key")
    val teamKey: String,
)