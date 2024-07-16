package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_MATCH_DETAILS

class MatchDetailsViewData private constructor(
    val matchNumber: String,
    val seriesName: String,
    val seriesKey: String
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_MATCH_DETAILS

    class Builder {
        private var matchNumber: String = ""
        private var seriesName: String = ""
        private var seriesKey: String = ""

        fun matchNumber(matchNumber: String) = apply {
            this.matchNumber = matchNumber
        }

        fun seriesName(seriesName: String) = apply {
            this.seriesName = seriesName
        }

        fun seriesKey(seriesKey: String) = apply {
            this.seriesKey = seriesKey
        }

        fun build() = MatchDetailsViewData(
            matchNumber,
            seriesName,
            seriesKey
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .matchNumber(matchNumber)
            .seriesName(seriesName)
            .seriesKey(seriesKey)
    }
}