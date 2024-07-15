package com.example.crexinfo.model.viewdatas

import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_RESULT_BADGE

class TeamFormViewData private constructor(
    val resultString: String
) : BaseViewType {

    override val viewType: Int
        get() = ITEM_RESULT_BADGE

    class Builder {
        private var resultString: String = ""

        fun resultString(resultString: String) = apply {
            this.resultString = resultString
        }

        fun build() = TeamFormViewData(resultString)
    }

    fun toBuilder(): Builder {
        return Builder().resultString(resultString)
    }
}