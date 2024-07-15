package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_MATCH_DETAILS

class MatchDetailsViewData private constructor(
    val teamOneShortName: String,
    val teamTwoShortName: String,
    val teamOneKey: String,
    val teamTwoKey: String,
    val matchTime: String,
    val matchDate: String,
    val matchNumber: String,
    val seriesName: String
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_MATCH_DETAILS

    class Builder {
        private var teamOneShortName: String = ""
        private var teamTwoShortName: String = ""
        private var teamOneKey: String = ""
        private var teamTwoKey: String = ""
        private var matchTime: String = ""
        private var matchDate: String = ""
        private var matchNumber: String = ""
        private var seriesName: String = ""

        fun teamOneShortName(teamOneShortName: String) = apply {
            this.teamOneShortName = teamOneShortName
        }

        fun teamTwoShortName(teamTwoShortName: String) = apply {
            this.teamTwoShortName = teamTwoShortName
        }

        fun teamOneKey(teamOneKey: String) = apply {
            this.teamOneKey = teamOneKey
        }

        fun teamTwoKey(teamTwoKey: String) = apply {
            this.teamTwoKey = teamTwoKey
        }

        fun matchTime(matchTime: String) = apply {
            this.matchTime = matchTime
        }

        fun matchNumber(matchNumber: String) = apply {
            this.matchNumber = matchNumber
        }

        fun matchDate(matchDate: String) = apply {
            this.matchDate = matchDate
        }

        fun seriesName(seriesName: String) = apply {
            this.seriesName = seriesName
        }

        fun build() = MatchDetailsViewData(
            teamOneShortName,
            teamTwoShortName,
            teamOneKey,
            teamTwoKey,
            matchTime,
            matchDate,
            matchNumber,
            seriesName
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .teamOneShortName(teamOneShortName)
            .teamTwoShortName(teamTwoShortName)
            .teamOneKey(teamOneKey)
            .teamTwoKey(teamTwoKey)
            .matchTime(matchTime)
            .matchDate(matchDate)
            .matchNumber(matchNumber)
            .seriesName(seriesName)
    }
}