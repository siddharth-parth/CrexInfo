package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_PLAYING_XI_TEAM
import com.example.crexinfo.model.PlayerViewData

class TeamSquadViewData private constructor(
    val teamName: String,
    val teamKey: String,
    val playingTeam: List<PlayerViewData>,
    val benchTeam: List<PlayerViewData>
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_PLAYING_XI_TEAM

    class Builder {
        private var teamName: String = ""
        private var teamKey: String = ""
        private var playingTeam: List<PlayerViewData> = emptyList()
        private var benchTeam: List<PlayerViewData> = emptyList()

        fun teamName(teamName: String) = apply {
            this.teamName = teamName
        }

        fun teamKey(teamKey: String) = apply {
            this.teamKey = teamKey
        }

        fun playingTeam(playingTeam: List<PlayerViewData>) = apply {
            this.playingTeam = playingTeam
        }

        fun benchTeam(benchTeam: List<PlayerViewData>) = apply {
            this.benchTeam = benchTeam
        }

        fun build() = TeamSquadViewData(
            teamName,
            teamKey,
            playingTeam,
            benchTeam
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .teamName(teamName)
            .teamKey(teamKey)
            .playingTeam(playingTeam)
            .benchTeam(benchTeam)
    }
}