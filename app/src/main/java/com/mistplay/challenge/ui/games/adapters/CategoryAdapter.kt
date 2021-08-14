package com.mistplay.challenge.ui.games.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mistplay.challenge.data.model.Category
import com.mistplay.challenge.databinding.ItemGameCategoryBinding

class CategoryAdapter : ListAdapter<Category, AdapterViewHolder>(Companion) {
    private val viewPool = RecyclerView.RecycledViewPool()

    companion object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            ItemGameCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val currentCategory = getItem(position)
        val itemBinding = holder.binding as ItemGameCategoryBinding

        itemBinding.gameCategory = currentCategory
        itemBinding.recyclerViewGames.setRecycledViewPool(viewPool)
        itemBinding.executePendingBindings()
    }
}