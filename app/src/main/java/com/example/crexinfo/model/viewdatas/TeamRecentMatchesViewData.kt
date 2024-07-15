package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_TEAM_RECENT_MATCHES

class TeamRecentMatchesViewData private constructor(
    val teamShortName: String,
    val teamForm: List<TeamFormViewData>,
    val teamRecentMatchesInfo: List<RecentMatchInfoViewData>,
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_TEAM_RECENT_MATCHES

    class Builder {
        private var teamShortName: String = ""
        private var teamForm: List<TeamFormViewData> = emptyList()
        private var teamRecentMatchesInfo: List<RecentMatchInfoViewData> = emptyList()

        fun teamShortName(teamShortName: String) = apply {
            this.teamShortName = teamShortName
        }

        fun teamForm(teamForm: List<TeamFormViewData>) = apply {
            this.teamForm = teamForm
        }

        fun teamRecentMatchesInfo(teamRecentMatchesInfo: List<RecentMatchInfoViewData>) = apply {
            this.teamRecentMatchesInfo = teamRecentMatchesInfo
        }

        fun build() = TeamRecentMatchesViewData(
            teamShortName,
            teamForm,
            teamRecentMatchesInfo
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .teamShortName(teamShortName)
            .teamForm(teamForm)
            .teamRecentMatchesInfo(teamRecentMatchesInfo)
    }
}