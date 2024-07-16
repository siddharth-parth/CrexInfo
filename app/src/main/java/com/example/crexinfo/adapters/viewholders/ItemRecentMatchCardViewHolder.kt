package com.example.crexinfo.adapters.viewholders

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.R
import com.example.crexinfo.databinding.ItemRecentMatchCardBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.RecentMatchInfoViewData

class ItemRecentMatchCardViewHolder(private val binding: ItemRecentMatchCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        val context = binding.root.context
        val data = viewData as? RecentMatchInfoViewData ?: return

        binding.apply {
            Glide.with(context)
                .load(data.teamOneKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamOne)

            Glide.with(context)
                .load(data.teamTwoKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeamTwo)

            tvTeamOne.text = data.teamOneName
            tvTeamTwo.text = data.teamTwoName

            tvTeamOneScore.text = data.teamOneScore
            tvTeamOneOversPlayed.text = data.teamOneOvers

            tvTeamTwoScore.text = data.teamTwoScore
            tvTeamTwoOversPlayed.text = data.teamTwoOvers

            tvMatchNumber.text = data.matchNumber

            layoutResultBadge.tvResultBadge.text = viewData.resultString
            if (viewData.resultString == "W") {
                layoutResultBadge.tvResultBadge.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        R.color.ce_highlight_ac6
                    )
                )
            } else {
                layoutResultBadge.tvResultBadge.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(
                        context,
                        R.color.ce_highlight_ac4
                    )
                )
            }
        }
    }
}