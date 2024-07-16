package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_MATCH_EVENT

class MatchEventViewData private constructor(
    val eventTime: String,
    val eventVenue: String,
    val broadcaster: String,
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_MATCH_EVENT

    class Builder {
        private var eventTime: String = ""
        private var eventVenue: String = ""
        private var broadcaster: String = ""
        private var seriesKey: String = ""

        fun eventTime(eventTime: String) = apply {
            this.eventTime = eventTime
        }

        fun eventVenue(eventVenue: String) = apply {
            this.eventVenue = eventVenue
        }

        fun broadcaster(broadcaster: String) = apply {
            this.broadcaster = broadcaster
        }

        fun build() = MatchEventViewData(
            eventTime,
            eventVenue,
            broadcaster,
        )
    }

    fun toBuilder(): Builder {
        return Builder()
            .eventTime(eventTime)
            .eventVenue(eventVenue)
            .broadcaster(broadcaster)
    }
}