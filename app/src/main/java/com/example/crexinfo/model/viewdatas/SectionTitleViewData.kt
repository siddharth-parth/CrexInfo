package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_SECTION_TITLE

class SectionTitleViewData private constructor(
    val title: String
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_SECTION_TITLE

    class Builder {
        private var title: String = ""

        fun title(title: String) = apply {
            this.title = title
        }

        fun build() = SectionTitleViewData(title)
    }

    fun toBuilder(): Builder {
        return Builder().title(title)
    }
}