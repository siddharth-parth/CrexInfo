package com.example.crexinfo.adapters.viewholders

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.R
import com.example.crexinfo.databinding.ItemBottomSheetPlayerBinding
import com.example.crexinfo.helper.FormatHelper.getPlayerHeadUrl
import com.example.crexinfo.helper.FormatHelper.getTeamJerseyUrl
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.PlayerViewData

class ItemPlayerViewHolder(private val binding: ItemBottomSheetPlayerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // binds data to the view if any
    fun bind(viewData: BaseViewType) {
        val data = viewData as? PlayerViewData ?: return

        binding.apply {
            val context = root.context

            // sets player head to the player head image view
            ViewHelper.loadImage(
                ivPlayerHead,
                data.playerKey.getPlayerHeadUrl(),
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_face_placeholder_helmet
                )
            )

            // sets team jersey to the player team jersey image view
            ViewHelper.loadImage(
                ivTeamJersey,
                data.teamKey.getTeamJerseyUrl(),
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_jersey
                )
            )

            tvPlayerRole.text = data.role
            if (viewData.isCaptain) {
                // appends captain tag to the player name if they are a captain
                tvPlayerName.text = "${data.playerName} (c)"
                tvPlayerName.setTextColor(ContextCompat.getColor(context, R.color.ce_highlight_ac2))
            } else {
                tvPlayerName.text = data.playerName
                tvPlayerName.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ce_primary_text_color
                    )
                )
            }

            val playerNameSetText = tvPlayerName.text
            if (viewData.isWicketKeeper) {
                // appends wicketkeeper tag to the player name if they are a wicketkeeper
                tvPlayerName.text = "${playerNameSetText} (wk)"
                tvPlayerName.setTextColor(ContextCompat.getColor(context, R.color.ce_highlight_ac2))
            } else {
                tvPlayerName.text = playerNameSetText
            }
        }
    }
}