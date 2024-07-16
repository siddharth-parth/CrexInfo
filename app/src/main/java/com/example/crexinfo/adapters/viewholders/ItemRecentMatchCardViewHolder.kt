package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.databinding.ItemRecentMatchCardBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.RecentMatchInfoViewData

class ItemRecentMatchCardViewHolder(private val binding: ItemRecentMatchCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        //TODO:
        val data = viewData as? RecentMatchInfoViewData ?: return

        binding.apply {
            Glide.with(ivTeamOne.context)
                .load(data.teamOneKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamOne)

            Glide.with(ivTeamTwo.context)
                .load(data.teamTwoKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamTwo)

            tvTeamOneScore.text = data.teamOneScore
            tvTeamOneOversPlayed.text = data.teamOneOvers

            tvTeamTwoScore.text = data.teamTwoScore
            tvTeamTwoOversPlayed.text = data.teamTwoOvers
        }
    }
}