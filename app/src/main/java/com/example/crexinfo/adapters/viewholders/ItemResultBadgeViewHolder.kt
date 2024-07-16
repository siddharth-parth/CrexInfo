package com.example.crexinfo.adapters.viewholders

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.R
import com.example.crexinfo.databinding.ItemMatchResultBadgeBinding
import com.example.crexinfo.model.viewdatas.TeamFormViewData

class ItemResultBadgeViewHolder(private val binding: ItemMatchResultBadgeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: TeamFormViewData) {
        binding.apply {
            val context = tvResultBadge.context

            tvResultBadge.text = viewData.resultString
            if (viewData.resultString == "W") {
                tvResultBadge.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        R.color.ce_highlight_ac6
                    )
                )
            } else {
                tvResultBadge.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        R.color.ce_highlight_ac4
                    )
                )
            }
        }
    }
}