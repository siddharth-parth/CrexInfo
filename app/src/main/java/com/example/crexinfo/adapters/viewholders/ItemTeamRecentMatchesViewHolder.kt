package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.adapters.InfoPageAdapterClickListener
import com.example.crexinfo.adapters.ResultBadgeAdapter
import com.example.crexinfo.databinding.ItemTeamRecentMatchesBinding
import com.example.crexinfo.helper.FormatHelper.getTeamLogoUrl
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.TeamRecentMatchesViewData

class ItemTeamRecentMatchesViewHolder(private val binding: ItemTeamRecentMatchesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private var mLastClickTime = System.currentTimeMillis()

    companion object {
        private const val CLICK_TIME_INTERVAL = 400
    }

    // binds data to the view if any
    fun bind(
        position: Int,
        viewData: BaseViewType,
        infoPageAdapterClickListener: InfoPageAdapterClickListener
    ) {
        binding.apply {
            val context = root.context
            val data = viewData as? TeamRecentMatchesViewData ?: return@apply

            tvTeam.text = data.teamShortName

            // sets team logo to the team logo image view
            ViewHelper.loadImage(
                ivTeam,
                data.teamKey.getTeamLogoUrl(),
                ViewHelper.getShimmer()
            )

            // initializes the team form recyclerview
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