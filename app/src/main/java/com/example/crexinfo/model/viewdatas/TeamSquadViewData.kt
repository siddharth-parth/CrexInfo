package com.example.crexinfo.model.viewdatas

import android.os.Parcelable
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_PLAYING_XI_TEAM
import kotlinx.parcelize.Parcelize

@Parcelize
class TeamSquadViewData private constructor(
    val teamName: String,
    val teamShortName: String,
    val teamKey: String,
    val playingTeam: List<PlayerViewData>,
    val benchTeam: List<PlayerViewData>
) : Parcelable, BaseViewType {

    override val viewType: Int
        get() = ITEM_PLAYING_XI_TEAM

    class Builder {
        private var teamName: String = ""
        private var teamShortName: String = ""
        private var teamKey: String = ""
        private var playingTeam: List<PlayerViewData> = emptyList()
        private var benchTeam: List<PlayerViewData> = emptyList()

        fun teamName(teamName: String) = apply {
            this.teamName = teamName
        }

        fun teamShortName(teamShortName: String) = apply {
            this.teamShortName = teamShortName
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
            teamShortName,
            teamKey,
            playingTeam,
            benchTeam
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .teamName(teamName)
            .teamShortName(teamShortName)
            .teamKey(teamKey)
            .playingTeam(playingTeam)
            .benchTeam(benchTeam)
    }
}