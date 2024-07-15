package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_PLAYING_XI_TEAM
import com.example.crexinfo.model.PlayerViewData

class TeamSquadViewData private constructor(
    val teamShortName: String,
    val playingTeam: List<PlayerViewData>,
    val benchTeam: List<PlayerViewData>
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_PLAYING_XI_TEAM

    class Builder {
        private var teamShortName: String = ""
        private var playingTeam: List<PlayerViewData> = emptyList()
        private var benchTeam: List<PlayerViewData> = emptyList()

        fun teamShortName(teamShortName: String) = apply {
            this.teamShortName = teamShortName
        }

        fun playingTeam(playingTeam: List<PlayerViewData>) = apply {
            this.playingTeam = playingTeam
        }

        fun benchTeam(benchTeam: List<PlayerViewData>) = apply {
            this.benchTeam = benchTeam
        }

        fun build() = TeamSquadViewData(
            teamShortName,
            playingTeam,
            benchTeam
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .teamShortName(teamShortName)
            .playingTeam(playingTeam)
            .benchTeam(benchTeam)
    }
}