package com.example.crexinfo.api.model

import com.google.gson.annotations.SerializedName

data class TeamComparisonNetwork(
    @SerializedName("on_venue")
    val onVenueStats: List<TeamComparisonStatsNetwork>,
    @SerializedName("overall")
    val overallStats: List<TeamComparisonStatsNetwork>
)