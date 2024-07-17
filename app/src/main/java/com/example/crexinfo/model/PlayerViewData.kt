package com.example.crexinfo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PlayerViewData private constructor(
    val isCaptain: Boolean,
    val isWicketKeeper: Boolean,
    val playerKey: String,
    val playerName: String,
    val role: String,
    val teamKey: String
) : Parcelable, BaseViewType {

    override val viewType: Int
        get() = ITEM_BOTTOM_SHEET_PLAYER

    class Builder {
        private var isCaptain: Boolean = false
        private var isWicketKeeper: Boolean = false
        private var playerKey: String = ""
        private var playerName: String = ""
        private var role: String = ""
        private var teamKey: String = ""

        fun isCaptain(isCaptain: Boolean) = apply {
            this.isCaptain = isCaptain
        }

        fun isWicketKeeper(isWicketKeeper: Boolean) = apply {
            this.isWicketKeeper = isWicketKeeper
        }

        fun playerKey(playerKey: String) = apply {
            this.playerKey = playerKey
        }

        fun playerName(playerName: String) = apply {
            this.playerName = playerName
        }

        fun role(role: String) = apply {
            this.role = role
        }

        fun teamKey(teamKey: String) = apply {
            this.teamKey = teamKey
        }

        fun build() = PlayerViewData(
            isCaptain,
            isWicketKeeper,
            playerKey,
            playerName,
            role,
            teamKey
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .isCaptain(isCaptain)
            .isWicketKeeper(isWicketKeeper)
            .playerKey(playerKey)
            .playerName(playerName)
            .role(role)
            .teamKey(teamKey)
    }
}