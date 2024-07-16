package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.adapters.InfoPageAdapterClickListener
import com.example.crexinfo.databinding.ItemTeamRecentMatchesBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.TeamRecentMatchesViewData

class ItemTeamRecentMatchesViewHolder(private val binding: ItemTeamRecentMatchesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        position: Int,
        viewData: BaseViewType,
        infoPageAdapterClickListener: InfoPageAdapterClickListener
    ) {
        binding.apply {
            val data = viewData as? TeamRecentMatchesViewData ?: return@apply

            tvTeam.text = data.teamShortName

            Glide.with(ivTeam.context)
                .load(data.teamKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeam)

            //TODO: form recyclerview

            root.setOnClickListener {
                infoPageAdapterClickListener.onTeamFormExpanded(
                    position,
                    viewData
                )
            }
        }
    }
}