package com.example.crexinfo.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.databinding.ItemSectionTitleBinding
import com.example.crexinfo.model.BaseViewType
import com.example.crexinfo.model.viewdatas.SectionTitleViewData

class ItemSectionTitleViewHolder(private val binding: ItemSectionTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(viewData: BaseViewType) {
        binding.apply {
            val data = viewData as? SectionTitleViewData ?: return@apply
            tvSectionTitle.text = data.title
        }
    }
}