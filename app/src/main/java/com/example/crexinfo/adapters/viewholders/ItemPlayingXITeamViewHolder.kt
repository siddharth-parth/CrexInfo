package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.adapters.InfoPageAdapterClickListener
import com.example.crexinfo.databinding.ItemPlayingXiTeamBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.TeamSquadViewData

class ItemPlayingXITeamViewHolder(private val binding: ItemPlayingXiTeamBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        position: Int,
        viewData: BaseViewType,
        infoPagerAdapterClickListener: InfoPageAdapterClickListener
    ) {
        binding.apply {
            val data = viewData as? TeamSquadViewData ?: return@apply

            tvTeam.text = data.teamName

            Glide.with(ivTeam.context)
                .load(data.teamKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeam)

            root.setOnClickListener {
                infoPagerAdapterClickListener.onTeamPlayingXIOpened(
                    position,
                    viewData
                )
            }
        }
    }
}