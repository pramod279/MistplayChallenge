package com.mistplay.challenge.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mistplay.challenge.data.model.Category
import com.mistplay.challenge.data.model.Games
import com.mistplay.challenge.ui.utils.Utils

class CategoryRepository {
    private val gameCategories = MutableLiveData<List<Category>>()

    /**
     * Function for Reading the Dummy Json Data from the Assets Folder
     * @return gameCategories
     */
    fun fetchCategories(context: Context): MutableLiveData<List<Category>> {
        val jsonFileString = Utils.getJsonDataFromAsset(context, "categories.json")
        if (jsonFileString != null) {
            val listCategoryType = object : TypeToken<List<Category>>() {}.type
            val categories: List<Category> = Gson().fromJson(jsonFileString, listCategoryType)
            val gameCategory = arrayListOf<Category>()
            for (category in categories) {
                val gamesList = arrayListOf<Games>()
                for (game in category.games) {
                    val book = Games("", game.title, game.img)
                    gamesList += book
                }
                gameCategory += Category("", category.categoryTitle, gamesList)
            }
            gameCategories.value = categories
        }
        return gameCategories
    }
}