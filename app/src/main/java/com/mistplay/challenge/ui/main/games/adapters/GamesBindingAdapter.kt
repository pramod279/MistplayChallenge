package com.mistplay.challenge.ui.main.games.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mistplay.challenge.data.model.Games

@BindingAdapter(value = ["setGames"])
fun RecyclerView.setRowGame(games: List<Games>?) {
    if (games != null) {
        val gamesAdapter = GameAdapter()
        gamesAdapter.submitList(games)
        adapter = gamesAdapter
    }
}