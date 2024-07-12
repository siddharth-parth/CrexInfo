package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_NONE
import com.example.crexinfo.model.ViewType

open class DynamicListViewData private constructor(
    @ViewType
    val viewType: Int,
    val data: BaseViewType?
) {
    class Builder {
        @ViewType
        private var viewType: Int = ITEM_NONE
        private var data: BaseViewType? = null

        fun viewType(@ViewType viewType: Int) = apply {
            this.viewType = viewType
        }

        fun data(data: BaseViewType?) = apply {
            this.data = data
        }

        fun build() = DynamicListViewData(viewType, data)
    }

    fun toBuilder(): Builder {
        return Builder()
            .viewType(viewType)
            .data(data)
    }
}