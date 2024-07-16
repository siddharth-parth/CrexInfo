package com.example.crexinfo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crexinfo.adapters.viewholders.ItemResultBadgeViewHolder
import com.example.crexinfo.databinding.ItemMatchResultBadgeBinding
import com.example.crexinfo.model.viewdatas.TeamFormViewData

class ResultBadgeAdapter(private val items: List<TeamFormViewData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemMatchResultBadgeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemResultBadgeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemResultBadgeViewHolder) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}