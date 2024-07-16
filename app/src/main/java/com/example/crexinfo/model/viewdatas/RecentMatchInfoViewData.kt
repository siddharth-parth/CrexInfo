package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_RECENT_MATCH_CARD

class RecentMatchInfoViewData private constructor(
    val matchNumber: String,
    val teamOneName: String,
    val teamOneOvers: String,
    val teamOneScore: String,
    val teamTwoName: String,
    val teamTwoOvers: String,
    val teamTwoScore: String,
    val resultString: String,
    val teamOneKey: String,
    val teamTwoKey: String
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_RECENT_MATCH_CARD

    class Builder {
        private var matchNumber: String = ""
        private var teamOneName: String = ""
        private var teamOneOvers: String = ""
        private var teamOneScore: String = ""
        private var teamTwoName: String = ""
        private var teamTwoOvers: String = ""
        private var teamTwoScore: String = ""
        private var resultString: String = ""
        private var teamOneKey: String = ""
        private var teamTwoKey: String = ""

        fun matchNumber(matchNumber: String) = apply {
            this.matchNumber = matchNumber
        }

        fun teamOneName(teamOneName: String) = apply {
            this.teamOneName = teamOneName
        }

        fun teamOneOvers(teamOneOvers: String) = apply {
            this.teamOneOvers = teamOneOvers
        }

        fun teamOneScore(teamOneScore: String) = apply {
            this.teamOneScore = teamOneScore
        }

        fun teamTwoName(teamTwoName: String) = apply {
            this.teamTwoName = teamTwoName
        }

        fun teamTwoOvers(teamTwoOvers: String) = apply {
            this.teamTwoOvers = teamTwoOvers
        }

        fun teamTwoScore(teamTwoScore: String) = apply {
            this.teamTwoScore = teamTwoScore
        }

        fun resultString(resultString: String) = apply {
            this.resultString = resultString
        }

        fun teamOneKey(teamOneKey: String) = apply {
            this.teamOneKey = teamOneKey
        }

        fun teamTwoKey(teamTwoKey: String) = apply {
            this.teamTwoKey = teamTwoKey
        }

        fun build() = RecentMatchInfoViewData(
            matchNumber,
            teamOneName,
            teamOneOvers,
            teamOneScore,
            teamTwoName,
            teamTwoOvers,
            teamTwoScore,
            resultString,
            teamOneKey,
            teamTwoKey
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .matchNumber(matchNumber)
            .teamOneName(teamOneName)
            .teamOneOvers(teamOneOvers)
            .teamOneScore(teamOneScore)
            .teamTwoName(teamTwoName)
            .teamTwoOvers(teamTwoOvers)
            .teamTwoScore(teamTwoScore)
            .resultString(resultString)
            .teamOneKey(teamOneKey)
            .teamTwoKey(teamTwoKey)
    }
}