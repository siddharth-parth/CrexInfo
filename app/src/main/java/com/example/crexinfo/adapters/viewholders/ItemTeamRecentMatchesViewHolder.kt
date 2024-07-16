package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.crexinfo.adapters.InfoPageAdapterClickListener
import com.example.crexinfo.adapters.ResultBadgeAdapter
import com.example.crexinfo.databinding.ItemTeamRecentMatchesBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogo
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.TeamRecentMatchesViewData

class ItemTeamRecentMatchesViewHolder(private val binding: ItemTeamRecentMatchesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var mLastClickTime = System.currentTimeMillis()

    companion object {
        private const val CLICK_TIME_INTERVAL = 400
    }

    fun bind(
        position: Int,
        viewData: BaseViewType,
        infoPageAdapterClickListener: InfoPageAdapterClickListener
    ) {
        binding.apply {
            val context = root.context
            val data = viewData as? TeamRecentMatchesViewData ?: return@apply

            tvTeam.text = data.teamShortName

            Glide.with(ivTeam.context)
                .load(data.teamKey.getTeamLogo())
                .placeholder(ViewHelper.getShimmer())
                .into(ivTeam)

            rvTeamForm.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvTeamForm.adapter = ResultBadgeAdapter(data.teamForm)

            root.setOnClickListener {
                val now = System.currentTimeMillis()
                if (now - mLastClickTime < CLICK_TIME_INTERVAL) {
                    return@setOnClickListener
                }
                mLastClickTime = now
                infoPageAdapterClickListener.onTeamFormExpanded(
                    position,
                    viewData
                )
            }
        }
    }
}