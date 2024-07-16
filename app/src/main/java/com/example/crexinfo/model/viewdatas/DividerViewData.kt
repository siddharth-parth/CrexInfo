package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_DIVIDER

class DividerViewData : BaseViewType {

    override val viewType: Int
        get() = ITEM_DIVIDER

    class Builder {
        fun build() = DividerViewData()
    }

    fun toBuilder(): Builder {
        return Builder()
    }
}