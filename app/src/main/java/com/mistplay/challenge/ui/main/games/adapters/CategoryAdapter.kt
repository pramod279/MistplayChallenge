package com.mistplay.challenge.ui.main.games.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mistplay.challenge.data.model.Category
import com.mistplay.challenge.databinding.ItemGameCategoryBinding
import com.mistplay.challenge.ui.base.BaseViewHolder

/**
 * Categories Adapter ==> Games Tab
 * Vertical Listing
 *
 * Created by Pramod Selvaraj on 14/08/2021.
 */
class CategoryAdapter : ListAdapter<Category, BaseViewHolder>(Companion) {
    private val viewPool = RecyclerView.RecycledViewPool()

    /*Diff Util For Updating The Recycler View If Any Change In Data*/
    companion object : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.categoryTitle == newItem.categoryTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            ItemGameCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        /*Binding The Current Item To The View*/
        val currentCategory = getItem(position)
        val itemBinding = holder.binding as ItemGameCategoryBinding

        itemBinding.gameCategory = currentCategory
        itemBinding.recyclerViewGames.setRecycledViewPool(viewPool)
        itemBinding.executePendingBindings()
    }
}