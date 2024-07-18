package com.example.crexinfo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.crexinfo.adapters.viewholders.ItemPlayerViewHolder
import com.example.crexinfo.adapters.viewholders.ItemSectionTitleViewHolder
import com.example.crexinfo.databinding.ItemBottomSheetPlayerBinding
import com.example.crexinfo.databinding.ItemSectionTitleBinding
import com.example.crexinfo.helper.ViewHelper
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.ITEM_BOTTOM_SHEET_PLAYER
import com.example.crexinfo.model.ITEM_SECTION_TITLE


class PlayersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // holds the items for the recycler view
    private var items: MutableList<BaseViewType> = mutableListOf()

    // returns the view holder for the recycler item based on the view type
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ITEM_BOTTOM_SHEET_PLAYER -> {
                val binding = ItemBottomSheetPlayerBinding.inflate(inflater, parent, false)
                ItemPlayerViewHolder(binding)
            }

            ITEM_SECTION_TITLE -> {
                val binding = ItemSectionTitleBinding.inflate(inflater, parent, false)
                ItemSectionTitleViewHolder(binding)
            }

            else -> {
                throw IllegalArgumentException("Invalid view type")
            }
        }
    }

    // binds the data to the recyclerview item based on the view type
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val layoutParams = StaggeredGridLayoutManager.LayoutParams(holder.itemView.layoutParams)
        val context = holder.itemView.context

        when (holder) {
            is ItemSectionTitleViewHolder -> {
                layoutParams.topMargin = ViewHelper.pxToDp(context, 24f)
                layoutParams.isFullSpan = true

                holder.bind(items[position])
            }

            is ItemPlayerViewHolder -> {
                layoutParams.topMargin = ViewHelper.pxToDp(context, 16f)
                layoutParams.isFullSpan = false
                holder.bind(items[position])
            }
        }

        holder.itemView.layoutParams = layoutParams
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    fun replaceItems(updatedItems: List<BaseViewType>) {
        items = updatedItems.toMutableList()
        notifyDataSetChanged()
    }
}