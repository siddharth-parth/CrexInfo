package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.databinding.ItemMatchDetailsBinding
import com.example.crexinfo.helper.FormatHelper.getSeriesLogoUrl
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.MatchDetailsViewData

class ItemMatchDetailsViewHolder(private val binding: ItemMatchDetailsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // binds data to the view if any
    fun bind(viewData: BaseViewType) {
        binding.apply {
            val data = viewData as? MatchDetailsViewData ?: return@apply

            tvMatchNumber.text = data.matchNumber
            tvSeries.text = data.seriesName

            ViewHelper.loadImage(
                ivSeries,
                data.seriesKey.getSeriesLogoUrl(),
                ViewHelper.getShimmer()
            )
        }
    }
}