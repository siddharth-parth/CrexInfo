package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_TEAM_COMPARISON

class TeamComparisonViewData private constructor(
    val onVenueStats: TeamComparisonStatsViewData,
    val overallStats: TeamComparisonStatsViewData,
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_TEAM_COMPARISON

    class Builder {
        private var onVenueStats: TeamComparisonStatsViewData =
            TeamComparisonStatsViewData.Builder().build()
        private var overallStats: TeamComparisonStatsViewData =
            TeamComparisonStatsViewData.Builder().build()

        fun onVenueStats(onVenueStats: TeamComparisonStatsViewData) = apply {
            this.onVenueStats = onVenueStats
        }

        fun overallStats(overallStats: TeamComparisonStatsViewData) = apply {
            this.overallStats = overallStats
        }

        fun build() = TeamComparisonViewData(
            onVenueStats,
            overallStats
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .onVenueStats(onVenueStats)
            .overallStats(overallStats)
    }
}