package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.databinding.ItemMatchDetailsBinding
import com.example.crexinfo.helper.FormatHelper.getSeriesLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.MatchDetailsViewData

class ItemMatchDetailsViewHolder(private val binding: ItemMatchDetailsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        binding.apply {
            val data = viewData as? MatchDetailsViewData ?: return@apply

            tvMatchNumber.text = data.matchNumber
            tvSeries.text = data.seriesName

            Glide.with(ivSeries.context)
                .load(data.seriesKey.getSeriesLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivSeries)
        }
    }
}