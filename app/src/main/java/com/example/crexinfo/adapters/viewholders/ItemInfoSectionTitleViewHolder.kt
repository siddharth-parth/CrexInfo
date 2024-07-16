package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.databinding.ItemInfoSectionTitleBinding
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.InfoSectionTitleViewData

class ItemInfoSectionTitleViewHolder(private val binding: ItemInfoSectionTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        binding.apply {
            val data = viewData as? InfoSectionTitleViewData ?: return@apply
            tvSectionTitle.text = data.title
        }
    }
}