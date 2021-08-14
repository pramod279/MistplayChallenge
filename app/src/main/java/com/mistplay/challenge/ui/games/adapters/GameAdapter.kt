package com.mistplay.challenge.ui.games.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.mistplay.challenge.data.model.Games
import com.mistplay.challenge.databinding.ItemGameBinding

class GameAdapter : ListAdapter<Games, AdapterViewHolder>(Companion) {
    companion object : DiffUtil.ItemCallback<Games>() {
        override fun areItemsTheSame(oldItem: Games, newItem: Games): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Games, newItem: Games): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(
            ItemGameBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val currentGame = getItem(position)
        val itemBinding = holder.binding as ItemGameBinding

        itemBinding.game = currentGame
        itemBinding.executePendingBindings()
    }
}