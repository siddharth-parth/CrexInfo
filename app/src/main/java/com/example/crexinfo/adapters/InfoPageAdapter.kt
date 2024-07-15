package com.example.crexinfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.adapters.viewholders.ItemDividerViewHolder
import com.example.crexinfo.adapters.viewholders.ItemInfoSectionTitleViewHolder
import com.example.crexinfo.adapters.viewholders.ItemMatchDetailsViewHolder
import com.example.crexinfo.adapters.viewholders.ItemMatchEventViewHolder
import com.example.crexinfo.adapters.viewholders.ItemPlayingXITeamViewHolder
import com.example.crexinfo.adapters.viewholders.ItemRecentMatchCardViewHolder
import com.example.crexinfo.adapters.viewholders.ItemSeeMoreFixturesViewHolder
import com.example.crexinfo.adapters.viewholders.ItemTeamComparisonViewHolder
import com.example.crexinfo.adapters.viewholders.ItemTeamRecentMatchesViewHolder
import com.example.crexinfo.databinding.ItemDividerBinding
import com.example.crexinfo.databinding.ItemInfoSectionTitleBinding
import com.example.crexinfo.databinding.ItemMatchDetailsBinding
import com.example.crexinfo.databinding.ItemMatchEventBinding
import com.example.crexinfo.databinding.ItemPlayingXiTeamBinding
import com.example.crexinfo.databinding.ItemRecentMatchCardBinding
import com.example.crexinfo.databinding.ItemSeeMoreFixturesBinding
import com.example.crexinfo.databinding.ItemTeamComparisonBinding
import com.example.crexinfo.databinding.ItemTeamRecentMatchesBinding
import com.example.crexinfo.model.ITEM_DIVIDER
import com.example.crexinfo.model.ITEM_INFO_SECTION_TITLE
import com.example.crexinfo.model.ITEM_MATCH_DETAILS
import com.example.crexinfo.model.ITEM_MATCH_EVENT
import com.example.crexinfo.model.ITEM_PLAYING_XI_TEAM
import com.example.crexinfo.model.ITEM_RECENT_MATCH_CARD
import com.example.crexinfo.model.ITEM_SEE_MORE_FIXTURES
import com.example.crexinfo.model.ITEM_TEAM_COMPARISON
import com.example.crexinfo.model.ITEM_TEAM_RECENT_MATCHES
import com.example.crexinfo.model.viewdatas.DividerViewData
import com.example.crexinfo.model.viewdatas.DynamicListViewData
import com.example.crexinfo.model.viewdatas.InfoSectionTitleViewData
import com.example.crexinfo.model.viewdatas.MatchDetailsViewData
import com.example.crexinfo.model.viewdatas.MatchEventViewData
import com.example.crexinfo.model.viewdatas.TeamSquadViewData
import com.example.crexinfo.model.viewdatas.RecentMatchInfoViewData
import com.example.crexinfo.model.viewdatas.SeeMoreFixturesViewData
import com.example.crexinfo.model.viewdatas.TeamComparisonViewData
import com.example.crexinfo.model.viewdatas.TeamRecentMatchesViewData

class InfoPageAdapter(private val items: List<DynamicListViewData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ITEM_MATCH_DETAILS -> {
                val binding = ItemMatchDetailsBinding.inflate(inflater, parent, false)
                ItemMatchDetailsViewHolder(binding)
            }

            ITEM_MATCH_EVENT -> {
                val binding = ItemMatchEventBinding.inflate(inflater, parent, false)
                ItemMatchEventViewHolder(binding)
            }

            ITEM_INFO_SECTION_TITLE -> {
                val binding = ItemInfoSectionTitleBinding.inflate(inflater, parent, false)
                ItemInfoSectionTitleViewHolder(binding)
            }

            ITEM_PLAYING_XI_TEAM -> {
                val binding = ItemPlayingXiTeamBinding.inflate(inflater, parent, false)
                ItemPlayingXITeamViewHolder(binding)
            }

            ITEM_TEAM_RECENT_MATCHES -> {
                val binding = ItemTeamRecentMatchesBinding.inflate(inflater, parent, false)
                ItemTeamRecentMatchesViewHolder(binding)
            }

            ITEM_RECENT_MATCH_CARD -> {
                val binding = ItemRecentMatchCardBinding.inflate(inflater, parent, false)
                ItemRecentMatchCardViewHolder(binding)
            }

            ITEM_DIVIDER -> {
                val binding = ItemDividerBinding.inflate(inflater, parent, false)
                ItemDividerViewHolder(binding)
            }

            ITEM_SEE_MORE_FIXTURES -> {
                val binding = ItemSeeMoreFixturesBinding.inflate(inflater, parent, false)
                ItemSeeMoreFixturesViewHolder(binding)
            }

            ITEM_TEAM_COMPARISON -> {
                val binding = ItemTeamComparisonBinding.inflate(inflater, parent, false)
                ItemTeamComparisonViewHolder(binding)
            }

            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is ItemDividerViewHolder -> {
                val data = items[position].data as? DividerViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemInfoSectionTitleViewHolder -> {
                val data = items[position].data as? InfoSectionTitleViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemMatchDetailsViewHolder -> {
                val data = items[position].data as? MatchDetailsViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemMatchEventViewHolder -> {
                val data = items[position].data as? MatchEventViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemPlayingXITeamViewHolder -> {
                val data = items[position].data as? TeamSquadViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemRecentMatchCardViewHolder -> {
                val data = items[position].data as? RecentMatchInfoViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemSeeMoreFixturesViewHolder -> {
                val data = items[position].data as? SeeMoreFixturesViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemTeamComparisonViewHolder -> {
                val data = items[position].data as? TeamComparisonViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }

            is ItemTeamRecentMatchesViewHolder -> {
                val data = items[position].data as? TeamRecentMatchesViewData
                    ?: throw IllegalArgumentException("Data cannot be null")

                holder.bind(data)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }
}