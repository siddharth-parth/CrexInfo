package com.example.crexinfo.model.viewdatas

class TeamComparisonStatsViewData private constructor(
    val teamOneAvgScore: Float,
    val teamOneHighestScore: Int,
    val teamOneLowestScore: Int,
    val teamOneMatches: Int,
    val teamOneName: String,
    val teamOneMatchesWon: Int,
    val teamTwoAvgScore: Float,
    val teamTwoHighestScore: Int,
    val teamTwoLowestScore: Int,
    val teamTwoMatches: Int,
    val teamTwoName: String,
    val teamTwoMatchesWon: Int
) {
    class Builder {
        private var teamOneAvgScore: Float = 0f
        private var teamOneHighestScore: Int = 0
        private var teamOneLowestScore: Int = 0
        private var teamOneMatches: Int = 0
        private var teamOneName: String = ""
        private var teamOneMatchesWon: Int = 0
        private var teamTwoAvgScore: Float = 0f
        private var teamTwoHighestScore: Int = 0
        private var teamTwoLowestScore: Int = 0
        private var teamTwoMatches: Int = 0
        private var teamTwoName: String = ""
        private var teamTwoMatchesWon: Int = 0

        fun teamOneAvgScore(teamOneAvgScore: Float) = apply {
            this.teamOneAvgScore = teamOneAvgScore
        }

        fun teamOneHighestScore(teamOneHighestScore: Int) = apply {
            this.teamOneHighestScore = teamOneHighestScore
        }

        fun teamOneLowestScore(teamOneLowestScore: Int) = apply {
            this.teamOneLowestScore = teamOneLowestScore
        }

        fun teamOneMatches(teamOneMatches: Int) = apply {
            this.teamOneMatches = teamOneMatches
        }

        fun teamOneName(teamOneName: String) = apply {
            this.teamOneName = teamOneName
        }

        fun teamOneMatchesWon(teamOneMatchesWon: Int) = apply {
            this.teamOneMatchesWon = teamOneMatchesWon
        }

        fun teamTwoAvgScore(teamTwoAvgScore: Float) = apply {
            this.teamTwoAvgScore = teamTwoAvgScore
        }

        fun teamTwoHighestScore(teamTwoHighestScore: Int) = apply {
            this.teamTwoHighestScore = teamTwoHighestScore
        }

        fun teamTwoLowestScore(teamTwoLowestScore: Int) = apply {
            this.teamTwoLowestScore = teamTwoLowestScore
        }

        fun teamTwoMatches(teamTwoMatches: Int) = apply {
            this.teamTwoMatches = teamTwoMatches
        }

        fun teamTwoName(teamTwoName: String) = apply {
            this.teamTwoName = teamTwoName
        }

        fun teamTwoMatchesWon(teamTwoMatchesWon: Int) = apply {
            this.teamTwoMatchesWon = teamTwoMatchesWon
        }

        fun build() = TeamComparisonStatsViewData(
            teamOneAvgScore,
            teamOneHighestScore,
            teamOneLowestScore,
            teamOneMatches,
            teamOneName,
            teamOneMatchesWon,
            teamTwoAvgScore,
            teamTwoHighestScore,
            teamTwoLowestScore,
            teamTwoMatches,
            teamTwoName,
            teamTwoMatchesWon
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .teamOneAvgScore(teamOneAvgScore)
            .teamOneHighestScore(teamOneHighestScore)
            .teamOneLowestScore(teamOneLowestScore)
            .teamOneMatches(teamOneMatches)
            .teamOneName(teamOneName)
            .teamOneMatchesWon(teamOneMatchesWon)
            .teamTwoAvgScore(teamTwoAvgScore)
            .teamTwoHighestScore(teamTwoHighestScore)
            .teamTwoLowestScore(teamTwoLowestScore)
            .teamTwoMatches(teamTwoMatches)
            .teamTwoName(teamTwoName)
            .teamTwoMatchesWon(teamTwoMatchesWon)
    }
}