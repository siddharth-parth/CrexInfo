package com.example.crexinfo.helper

import com.example.crexinfo.api.model.MatchInfoNetwork
import com.example.crexinfo.api.model.PlayerNetwork
import com.example.crexinfo.api.model.RecentMatchInfoNetwork
import com.example.crexinfo.api.model.TeamComparisonNetwork
import com.example.crexinfo.api.model.TeamComparisonStatsNetwork
import com.example.crexinfo.model.PlayerViewData
import com.example.crexinfo.model.viewdatas.MatchDetailsViewData
import com.example.crexinfo.model.viewdatas.MatchEventViewData
import com.example.crexinfo.model.viewdatas.MatchInfoViewData
import com.example.crexinfo.model.viewdatas.RecentMatchInfoViewData
import com.example.crexinfo.model.viewdatas.TeamComparisonStatsViewData
import com.example.crexinfo.model.viewdatas.TeamComparisonViewData
import com.example.crexinfo.model.viewdatas.TeamFormViewData
import com.example.crexinfo.model.viewdatas.TeamRecentMatchesViewData
import com.example.crexinfo.model.viewdatas.TeamSquadViewData

object ViewDataConverter {

    /**
     * converts [MatchInfoNetwork] to [MatchInfoViewData]
     */
    fun convertMatchInfo(matchInfoNetwork: MatchInfoNetwork): MatchInfoViewData {
        return MatchInfoViewData.Builder()
            .matchDetails(convertMatchDetails(matchInfoNetwork))
            .matchEvent(convertMatchEvent(matchInfoNetwork))
            .teamsSquad(convertTeamsSquad(matchInfoNetwork))
            .teamsRecentMatches(convertTeamRecentMatches(matchInfoNetwork))
            .teamsComparison(convertTeamComparison(matchInfoNetwork.teamComparison))
            .build()
    }

    /**
     * extracts [MatchDetailsViewData] from [MatchInfoNetwork]
     */
    private fun convertMatchDetails(matchInfoNetwork: MatchInfoNetwork): MatchDetailsViewData {
        return MatchDetailsViewData.Builder()
            .teamOneShortName(matchInfoNetwork.teamOneShort)
            .teamTwoShortName(matchInfoNetwork.teamTwoShort)
            .matchTime(FormatHelper.extractTime(matchInfoNetwork.matchTime))
            .matchDate(FormatHelper.extractDayAndMonthAbbreviation(matchInfoNetwork.matchTime))
            .matchNumber(matchInfoNetwork.matchNumber)
            .seriesName(matchInfoNetwork.seriesName)
            .build()
    }

    /**
     * extracts [MatchEventViewData] from [MatchInfoNetwork]
     */
    private fun convertMatchEvent(matchInfoNetwork: MatchInfoNetwork): MatchEventViewData {
        return MatchEventViewData.Builder()
            .eventTime(FormatHelper.extractFormattedDateTime(matchInfoNetwork.matchTime))
            .eventVenue(matchInfoNetwork.venueName)
            .broadcaster(matchInfoNetwork.broadcaster)
            .build()
    }

    /**
     * extracts list of [TeamSquadViewData] from [MatchInfoNetwork]
     */
    private fun convertTeamsSquad(matchInfoNetwork: MatchInfoNetwork): List<TeamSquadViewData> {
        return listOf(
            TeamSquadViewData.Builder()
                .teamShortName(matchInfoNetwork.teamOneShort)
                .playingTeam(convertPlayer(matchInfoNetwork.teamOnePlaying))
                .benchTeam(convertPlayer(matchInfoNetwork.teamOneBench))
                .build(),
            TeamSquadViewData.Builder()
                .teamShortName(matchInfoNetwork.teamTwoShort)
                .playingTeam(convertPlayer(matchInfoNetwork.teamTwoPlaying))
                .benchTeam(convertPlayer(matchInfoNetwork.teamTwoBench))
                .build()
        )
    }

    /**
     * converts list of [PlayerNetwork] to list of [PlayerViewData]
     */
    private fun convertPlayer(playersNetwork: List<PlayerNetwork>): List<PlayerViewData> {
        return playersNetwork.map { playerNetwork ->
            PlayerViewData.Builder()
                .isCaptain(playerNetwork.isCaptain)
                .isWicketKeeper(playerNetwork.isWicketKeeper)
                .playerKey(playerNetwork.playerKey)
                .playerName(playerNetwork.playerName)
                .role(playerNetwork.role)
                .teamKey(playerNetwork.teamKey)
                .build()
        }
    }

    /**
     * extracts list of [TeamRecentMatchesViewData] from [MatchInfoNetwork]
     */
    private fun convertTeamRecentMatches(matchInfoNetwork: MatchInfoNetwork): List<TeamRecentMatchesViewData> {
        val teamForms = matchInfoNetwork.teamForm.split("-")
        val teamOneForm = FormatHelper.parseTeamForm(teamForms[0])
        val teamTwoForm = FormatHelper.parseTeamForm(teamForms[1])

        return listOf(
            TeamRecentMatchesViewData.Builder()
                .teamShortName(matchInfoNetwork.teamOneShort)
                .teamRecentMatchesInfo(
                    convertRecentMatchInfo(
                        matchInfoNetwork.teamOneRecentMatchesInfo,
                        teamOneForm
                    )
                )
                .teamForm(
                    teamOneForm.map { resultString ->
                        TeamFormViewData.Builder()
                            .resultString(resultString)
                            .build()
                    }
                )
                .build(),
            TeamRecentMatchesViewData.Builder()
                .teamShortName(matchInfoNetwork.teamTwoShort)
                .teamRecentMatchesInfo(
                    convertRecentMatchInfo(
                        matchInfoNetwork.teamTwoRecentMatchesInfo,
                        teamTwoForm
                    )
                )
                .teamForm(
                    teamTwoForm.map { resultString ->
                        TeamFormViewData.Builder()
                            .resultString(resultString)
                            .build()
                    }
                )
                .build()
        )
    }

    /**
     * converts list of [RecentMatchInfoNetwork] to list of [RecentMatchInfoViewData]
     */
    private fun convertRecentMatchInfo(
        recentMatchesInfoNetwork: List<RecentMatchInfoNetwork>,
        teamForm: List<String>
    ): List<RecentMatchInfoViewData> {
        return recentMatchesInfoNetwork.mapIndexed { ind, recentMatchInfoNetwork ->
            RecentMatchInfoViewData.Builder()
                .matchNumber(recentMatchInfoNetwork.matchNumber)
                .teamOneName(recentMatchInfoNetwork.teamOne)
                .teamOneOvers(recentMatchInfoNetwork.teamOneOvers)
                .teamOneScore(recentMatchInfoNetwork.teamOneScore)
                .teamTwoName(recentMatchInfoNetwork.teamTwo)
                .teamTwoOvers(recentMatchInfoNetwork.teamTwoOvers)
                .teamTwoScore(recentMatchInfoNetwork.teamTwoScore)
                .resultString(teamForm[ind])
                .build()
        }
    }

    /**
     * converts [TeamComparisonNetwork] to [TeamComparisonViewData]
     */
    private fun convertTeamComparison(teamComparisonNetwork: TeamComparisonNetwork): TeamComparisonViewData {
        return TeamComparisonViewData.Builder()
            .overallStats(convertTeamComparisonStats(teamComparisonNetwork.overallStats))
            .onVenueStats(convertTeamComparisonStats(teamComparisonNetwork.onVenueStats))
            .build()
    }

    /**
     * converts list of [TeamComparisonStatsNetwork] to [TeamComparisonViewData]
     */
    private fun convertTeamComparisonStats(teamComparisonStatsNetwork: List<TeamComparisonStatsNetwork>): TeamComparisonStatsViewData {
        val teamOneStats = teamComparisonStatsNetwork.first()
        val teamTwoStats = teamComparisonStatsNetwork[1]

        return TeamComparisonStatsViewData.Builder()
            .teamOneAvgScore(teamOneStats.avgScore)
            .teamOneHighestScore(teamOneStats.highestScore)
            .teamOneLowestScore(teamOneStats.lowestScore)
            .teamOneMatches(teamOneStats.matches)
            .teamOneName(teamOneStats.teamName)
            .teamOneMatchesWon(teamOneStats.won)
            .teamTwoAvgScore(teamTwoStats.avgScore)
            .teamTwoHighestScore(teamTwoStats.highestScore)
            .teamTwoLowestScore(teamTwoStats.lowestScore)
            .teamTwoMatches(teamTwoStats.matches)
            .teamTwoName(teamTwoStats.teamName)
            .teamTwoMatchesWon(teamTwoStats.won)
            .build()
    }
}