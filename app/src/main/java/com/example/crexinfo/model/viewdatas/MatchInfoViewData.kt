package com.example.crexinfo.model.viewdatas

class MatchInfoViewData private constructor(
    val teamOneShortName: String,
    val teamTwoShortName: String,
    val teamOneKey: String,
    val teamTwoKey: String,
    val matchTime: String,
    val matchDate: String,
    val matchDetails: MatchDetailsViewData,
    val matchEvent: MatchEventViewData,
    val teamsSquad: List<TeamSquadViewData>, // contains the list of squad of both the teams
    val teamsRecentMatches: List<TeamRecentMatchesViewData>, // contains the list of recent matches of both the teams
    val teamsComparison: TeamComparisonViewData,
) {
    class Builder {
        private var teamOneShortName: String = ""
        private var teamTwoShortName: String = ""
        private var teamOneKey: String = ""
        private var teamTwoKey: String = ""
        private var matchTime: String = ""
        private var matchDate: String = ""
        private var matchDetails: MatchDetailsViewData = MatchDetailsViewData.Builder().build()
        private var matchEvent: MatchEventViewData = MatchEventViewData.Builder().build()
        private var teamsSquad: List<TeamSquadViewData> = emptyList()
        private var teamsRecentMatches: List<TeamRecentMatchesViewData> = emptyList()
        private var teamsComparison: TeamComparisonViewData =
            TeamComparisonViewData.Builder().build()

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

        fun matchDate(matchDate: String) = apply {
            this.matchDate = matchDate
        }

        fun matchDetails(matchDetails: MatchDetailsViewData) = apply {
            this.matchDetails = matchDetails
        }

        fun matchEvent(matchEvent: MatchEventViewData) = apply {
            this.matchEvent = matchEvent
        }

        fun teamsSquad(teamsSquad: List<TeamSquadViewData>) = apply {
            this.teamsSquad = teamsSquad
        }

        fun teamsRecentMatches(teamsRecentMatches: List<TeamRecentMatchesViewData>) = apply {
            this.teamsRecentMatches = teamsRecentMatches
        }

        fun teamsComparison(teamsComparison: TeamComparisonViewData) = apply {
            this.teamsComparison = teamsComparison
        }

        fun build() = MatchInfoViewData(
            teamOneShortName,
            teamTwoShortName,
            teamOneKey,
            teamTwoKey,
            matchTime,
            matchDate,
            matchDetails,
            matchEvent,
            teamsSquad,
            teamsRecentMatches,
            teamsComparison
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
            .matchDetails(matchDetails)
            .matchEvent(matchEvent)
            .teamsSquad(teamsSquad)
            .teamsRecentMatches(teamsRecentMatches)
            .teamsComparison(teamsComparison)
    }
}