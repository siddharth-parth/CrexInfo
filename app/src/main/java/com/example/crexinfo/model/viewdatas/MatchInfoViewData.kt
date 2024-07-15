package com.example.crexinfo.model.viewdatas

class MatchInfoViewData private constructor(
    val matchDetails: MatchDetailsViewData,
    val matchEvent: MatchEventViewData,
    val teamsSquad: List<TeamSquadViewData>, // contains the list of squad of both the teams
    val teamsRecentMatches: List<TeamRecentMatchesViewData>, // contains the list of recent matches of both the teams
    val teamsComparison: TeamComparisonViewData
) {
    class Builder {
        private var matchDetails: MatchDetailsViewData = MatchDetailsViewData.Builder().build()
        private var matchEvent: MatchEventViewData = MatchEventViewData.Builder().build()
        private var teamsSquad: List<TeamSquadViewData> = emptyList()
        private var teamsRecentMatches: List<TeamRecentMatchesViewData> = emptyList()
        private var teamsComparison: TeamComparisonViewData =
            TeamComparisonViewData.Builder().build()

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
            matchDetails,
            matchEvent,
            teamsSquad,
            teamsRecentMatches,
            teamsComparison
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .matchDetails(matchDetails)
            .matchEvent(matchEvent)
            .teamsSquad(teamsSquad)
            .teamsRecentMatches(teamsRecentMatches)
            .teamsComparison(teamsComparison)
    }
}