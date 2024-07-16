package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_SEE_MORE_FIXTURES

class SeeMoreFixturesViewData : BaseViewType {

    override val viewType: Int
        get() = ITEM_SEE_MORE_FIXTURES

    class Builder {
        fun build() = SeeMoreFixturesViewData()
    }

    fun toBuilder(): Builder {
        return Builder()
    }
}