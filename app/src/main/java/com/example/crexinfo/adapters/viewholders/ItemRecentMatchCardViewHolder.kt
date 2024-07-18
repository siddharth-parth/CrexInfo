package com.example.crexinfo.adapters.viewholders

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.R
import com.example.crexinfo.databinding.ItemRecentMatchCardBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogoUrl
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.RecentMatchInfoViewData

class ItemRecentMatchCardViewHolder(private val binding: ItemRecentMatchCardBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // binds data to the view if any
    fun bind(viewData: BaseViewType) {
        val context = binding.root.context
        val data = viewData as? RecentMatchInfoViewData ?: return

        binding.apply {
            // sets team logo to the first team logo image view
            ViewHelper.loadImage(
                ivTeamOne,
                data.teamOneKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            // sets team logo to the second team logo image view
            ViewHelper.loadImage(
                ivTeamTwo,
                data.teamTwoKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            tvTeamOne.text = data.teamOneName
            tvTeamTwo.text = data.teamTwoName

            tvTeamOneScore.text = data.teamOneScore
            tvTeamOneOversPlayed.text = data.teamOneOvers

            tvTeamTwoScore.text = data.teamTwoScore
            tvTeamTwoOversPlayed.text = data.teamTwoOvers

            tvMatchNumber.text = data.matchNumber

            layoutResultBadge.tvResultBadge.text = viewData.resultString

            // sets the result badge color as per Win/Loss
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