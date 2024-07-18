package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.adapters.InfoPageAdapterClickListener
import com.example.crexinfo.databinding.ItemPlayingXiTeamBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogoUrl
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.TeamSquadViewData

class ItemPlayingXITeamViewHolder(private val binding: ItemPlayingXiTeamBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // binds data to the view if any
    fun bind(
        position: Int,
        viewData: BaseViewType,
        infoPagerAdapterClickListener: InfoPageAdapterClickListener
    ) {
        binding.apply {
            val data = viewData as? TeamSquadViewData ?: return@apply

            tvTeam.text = data.teamName

            // sets team logo to the team logo image view
            ViewHelper.loadImage(
                ivTeam,
                data.teamKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            root.setOnClickListener {
                infoPagerAdapterClickListener.onTeamPlayingXIOpened(
                    position,
                    viewData
                )
            }
        }
    }
}