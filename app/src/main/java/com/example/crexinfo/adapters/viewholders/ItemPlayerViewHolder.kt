package com.example.crexinfo.adapters.viewholders

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.R
import com.example.crexinfo.databinding.ItemBottomSheetPlayerBinding
import com.example.crexinfo.helper.FormatHelper.getPlayerHead
import com.example.crexinfo.helper.FormatHelper.getTeamJersey
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.PlayerViewData

class ItemPlayerViewHolder(private val binding: ItemBottomSheetPlayerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        val data = viewData as? PlayerViewData ?: return

        binding.apply {
            val context = root.context

            Glide.with(context)
                .load(data.playerKey.getPlayerHead())
                .placeholder(R.drawable.ic_face_placeholder_helmet)
                .into(ivPlayerHead)

            Glide.with(context)
                .load(data.teamKey.getTeamJersey())
                .placeholder(R.drawable.ic_jersey)
                .into(ivTeamJersey)

            tvPlayerRole.text = data.role

            if (viewData.isCaptain) {
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
                tvPlayerName.text = "${playerNameSetText} (wk)"
                tvPlayerName.setTextColor(ContextCompat.getColor(context, R.color.ce_highlight_ac2))
            } else {
                tvPlayerName.text = playerNameSetText
            }
        }
    }
}