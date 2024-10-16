package com.example.crexinfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.adapters.viewholders.ItemDividerViewHolder
import com.example.crexinfo.adapters.viewholders.ItemMatchDetailsViewHolder
import com.example.crexinfo.adapters.viewholders.ItemMatchEventViewHolder
import com.example.crexinfo.adapters.viewholders.ItemPlayingXITeamViewHolder
import com.example.crexinfo.adapters.viewholders.ItemRecentMatchCardViewHolder
import com.example.crexinfo.adapters.viewholders.ItemSectionTitleViewHolder
import com.example.crexinfo.adapters.viewholders.ItemSeeMoreFixturesViewHolder
import com.example.crexinfo.adapters.viewholders.ItemTeamComparisonViewHolder
import com.example.crexinfo.adapters.viewholders.ItemTeamRecentMatchesViewHolder
import com.example.crexinfo.databinding.ItemDividerBinding
import com.example.crexinfo.databinding.ItemMatchDetailsBinding
import com.example.crexinfo.databinding.ItemMatchEventBinding
import com.example.crexinfo.databinding.ItemPlayingXiTeamBinding
import com.example.crexinfo.databinding.ItemRecentMatchCardBinding
import com.example.crexinfo.databinding.ItemSectionTitleBinding
import com.example.crexinfo.databinding.ItemSeeMoreFixturesBinding
import com.example.crexinfo.databinding.ItemTeamComparisonBinding
import com.example.crexinfo.databinding.ItemTeamRecentMatchesBinding
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_DIVIDER
import com.example.crexinfo.model.ITEM_MATCH_DETAILS
import com.example.crexinfo.model.ITEM_MATCH_EVENT
import com.example.crexinfo.model.ITEM_PLAYING_XI_TEAM
import com.example.crexinfo.model.ITEM_RECENT_MATCH_CARD
import com.example.crexinfo.model.ITEM_SECTION_TITLE
import com.example.crexinfo.model.ITEM_SEE_MORE_FIXTURES
import com.example.crexinfo.model.ITEM_TEAM_COMPARISON
import com.example.crexinfo.model.ITEM_TEAM_RECENT_MATCHES

class InfoPageAdapter(private val infoPagerAdapterClickListener: InfoPageAdapterClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // holds the items of the recycler view
    val items: MutableList<BaseViewType> = mutableListOf()

    // returns the view holder for the recycler item based on the view type
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

            ITEM_SECTION_TITLE -> {
                val binding = ItemSectionTitleBinding.inflate(inflater, parent, false)
                ItemSectionTitleViewHolder(binding)
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

    // binds the data to the recyclerview item based on the view type
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is ItemDividerViewHolder -> {
                holder.bind()
            }

            is ItemSectionTitleViewHolder -> {
                holder.bind(items[position])
            }

            is ItemMatchDetailsViewHolder -> {
                holder.bind(items[position])
            }

            is ItemMatchEventViewHolder -> {
                holder.bind(items[position])
            }

            is ItemPlayingXITeamViewHolder -> {
                holder.bind(
                    position,
                    items[position],
                    infoPagerAdapterClickListener
                )
            }

            is ItemRecentMatchCardViewHolder -> {
                holder.bind(items[position])
            }

            is ItemSeeMoreFixturesViewHolder -> {
                holder.bind(items[position])
            }

            is ItemTeamComparisonViewHolder -> {
                holder.bind(items[position])
            }

            is ItemTeamRecentMatchesViewHolder -> {
                holder.bind(
                    position,
                    items[position],
                    infoPagerAdapterClickListener
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    // adds an item to the recyclerview and notifies about the inserted item
    fun addItem(item: BaseViewType) {
        items.add(item)
        notifyItemInserted((items.size - 1))
    }

    // adds an item to the recyclerview at the specified index and notifies about the inserted item
    fun addItemAtIndex(ind: Int, item: BaseViewType) {
        items.add(ind, item)
        notifyItemInserted(ind)
    }

    // adds items to the recyclerview and notifies about the inserted range of items
    fun addItems(newItems: List<BaseViewType>) {
        val oldInd = items.size
        items.addAll(newItems)
        notifyItemRangeInserted(oldInd, newItems.size)
    }

    // adds items to the recyclerview at an index and notifies about the inserted range of items
    fun addItemsAtIndex(ind: Int, newItems: List<BaseViewType>) {
        items.addAll(ind, newItems)
        notifyItemRangeInserted(ind, newItems.size)
    }

    // removes items from the recyclerview at an index and notifies about the removed range of items
    fun removeItemsAtIndex(ind: Int, removedItems: List<BaseViewType>) {
        items.removeAll(removedItems)
        notifyItemRangeRemoved(ind, ind + (removedItems.size))
    }

    // updates the item in the recyclerview at an index and notifies about the item changed
    fun updateItemAtIndex(ind: Int, updatedItem: BaseViewType) {
        items[ind] = updatedItem
        notifyItemChanged(ind)
    }
}

interface InfoPageAdapterClickListener {
    // callback for when team form is expanded
    fun onTeamFormExpanded(position: Int, viewData: BaseViewType)

    // callback for when playing xi is opened
    fun onTeamPlayingXIOpened(position: Int, viewData: BaseViewType)
}