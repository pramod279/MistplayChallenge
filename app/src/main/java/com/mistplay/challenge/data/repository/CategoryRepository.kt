package com.mistplay.challenge.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mistplay.challenge.data.model.Category
import com.mistplay.challenge.data.model.Games
import com.mistplay.challenge.ui.utils.Utils

/**
 * Repository For Fetching Categories Data From Store
 *
 * Created by Pramod Selvaraj on 13/08/2021.
 */
class CategoryRepository {
    private var gameCategories = listOf<Category>()

    /**
     * Function for Reading the Dummy Json Data from the Assets Folder
     * @return gameCategories
     */
    fun fetchCategories(context: Context): List<Category> {
        val jsonFileString = Utils.getJsonDataFromAsset(context, "categories.json")
        if (jsonFileString != null) {
            val listCategoryType = object : TypeToken<List<Category>>() {}.type
            val categories: List<Category> = Gson().fromJson(jsonFileString, listCategoryType)
            val gameCategory = arrayListOf<Category>()
            for (category in categories) {
                val games = arrayListOf<Games>()
                for (game in category.games) {
                    games += Games(game.title, game.img)
                }
                gameCategory += Category(category.categoryTitle, games)
            }
            gameCategories = categories
        }
        return gameCategories
    }
}