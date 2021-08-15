package com.mistplay.challenge.ui.main.games.viewmodel

import android.content.Context
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.mistplay.challenge.data.model.Category
import com.mistplay.challenge.data.repository.CategoryRepository

/**
 * Games Tab View Models
 *
 * Created by Pramod Selvaraj on 13/08/2021.
 */
class GamesViewModel : ViewModel() {

    private val repository = CategoryRepository()

    var mediatorLiveData: MediatorLiveData<List<Category>> = MediatorLiveData<List<Category>>()

    /*Fetching all the Categories From The Repository*/
    fun fetchAllCategories(context: Context) {
        mediatorLiveData.addSource(
            repository.fetchCategories(context)
        ) {
            mediatorLiveData.postValue(it)
        }
    }
}