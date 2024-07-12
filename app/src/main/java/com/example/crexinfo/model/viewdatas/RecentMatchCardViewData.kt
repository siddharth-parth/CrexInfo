package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_RECENT_MATCH_CARD

class RecentMatchCardViewData private constructor(

) : BaseViewType {

    override val viewType: Int
        get() = ITEM_RECENT_MATCH_CARD
}