package com.example.crexinfo.api.model

import com.google.gson.annotations.SerializedName

data class MatchInfoNetwork(
    @SerializedName("broadcaster")
    val broadcaster: String,
    @SerializedName("match_number")
    val matchNumber: String,
    @SerializedName("match_time")
    val matchTime: String,
    @SerializedName("series_name")
    val seriesName: String,
    @SerializedName("team1_bench")
    val teamOneBench: List<PlayerNetwork>,
    @SerializedName("team1_form")
    val teamOneRecentMatchesInfo: List<RecentMatchInfoNetwork>,
    @SerializedName("team1_full")
    val teamOneFull: String,
    @SerializedName("team1_key")
    val teamOneKey: String,
    @SerializedName("team1_playing")
    val teamOnePlaying: List<PlayerNetwork>,
    @SerializedName("team1_short")
    val teamOneShort: String,
    @SerializedName("team2_bench")
    val teamTwoBench: List<PlayerNetwork>,
    @SerializedName("team2_form")
    val teamTwoRecentMatchesInfo: List<RecentMatchInfoNetwork>,
    @SerializedName("team2_full")
    val teamTwoFull: String,
    @SerializedName("team2_key")
    val teamTwoKey: String,
    @SerializedName("team2_playing")
    val teamTwoPlaying: List<PlayerNetwork>,
    @SerializedName("team2_short")
    val teamTwoShort: String,
    @SerializedName("team_comparison")
    val teamComparison: TeamComparisonNetwork,
    @SerializedName("team_form")
    val teamForm: String,
    @SerializedName("venue_name")
    val venueName: String,
    @SerializedName("series_key")
    val seriesKey: String,
)