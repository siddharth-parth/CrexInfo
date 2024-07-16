package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.databinding.ItemSeeMoreFixturesBinding
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.SeeMoreFixturesViewData

class ItemSeeMoreFixturesViewHolder(binding: ItemSeeMoreFixturesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        //TODO:
        val data = viewData as? SeeMoreFixturesViewData ?: return
    }
}