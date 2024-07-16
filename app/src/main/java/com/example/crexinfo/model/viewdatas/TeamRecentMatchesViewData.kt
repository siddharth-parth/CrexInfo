package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_TEAM_RECENT_MATCHES

class TeamRecentMatchesViewData private constructor(
    val teamShortName: String,
    val teamKey: String,
    val teamForm: List<TeamFormViewData>,
    val teamRecentMatchesInfo: List<RecentMatchInfoViewData>,
    val isTeamOne: Boolean,
    val isExpanded: Boolean
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_TEAM_RECENT_MATCHES

    class Builder {
        private var teamShortName: String = ""
        private var teamKey: String = ""
        private var teamForm: List<TeamFormViewData> = emptyList()
        private var teamRecentMatchesInfo: List<RecentMatchInfoViewData> = emptyList()
        private var isTeamOne: Boolean = false
        private var isExpanded: Boolean = false

        fun teamShortName(teamShortName: String) = apply {
            this.teamShortName = teamShortName
        }

        fun teamKey(teamKey: String) = apply {
            this.teamKey = teamKey
        }

        fun teamForm(teamForm: List<TeamFormViewData>) = apply {
            this.teamForm = teamForm
        }

        fun teamRecentMatchesInfo(teamRecentMatchesInfo: List<RecentMatchInfoViewData>) = apply {
            this.teamRecentMatchesInfo = teamRecentMatchesInfo
        }

        fun isTeamOne(isTeamOne: Boolean) = apply {
            this.isTeamOne = isTeamOne
        }

        fun isExpanded(isExpanded: Boolean) = apply {
            this.isExpanded = isExpanded
        }

        fun build() = TeamRecentMatchesViewData(
            teamShortName,
            teamKey,
            teamForm,
            teamRecentMatchesInfo,
            isTeamOne,
            isExpanded
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .teamShortName(teamShortName)
            .teamKey(teamKey)
            .teamForm(teamForm)
            .teamRecentMatchesInfo(teamRecentMatchesInfo)
            .isTeamOne(isTeamOne)
            .isExpanded(isExpanded)
    }
}