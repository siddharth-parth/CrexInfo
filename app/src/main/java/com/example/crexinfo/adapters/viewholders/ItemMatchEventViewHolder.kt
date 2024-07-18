package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.databinding.ItemMatchEventBinding
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.MatchEventViewData

class ItemMatchEventViewHolder(private val binding: ItemMatchEventBinding) :
    RecyclerView.ViewHolder(binding.root) {

    // binds data to the view if any
    fun bind(viewData: BaseViewType) {
        binding.apply {
            val data = viewData as? MatchEventViewData ?: return@apply

            tvEventTime.text = data.eventTime
            tvEventPlace.text = data.eventVenue
            tvStream.text = data.broadcaster
        }
    }
}