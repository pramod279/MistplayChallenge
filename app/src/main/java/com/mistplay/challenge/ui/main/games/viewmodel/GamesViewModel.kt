package com.mistplay.challenge.ui.main.games.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mistplay.challenge.data.model.Category
import com.mistplay.challenge.data.repository.CategoryRepository
import com.mistplay.challenge.ui.utils.Coroutines
import kotlinx.coroutines.Job

/**
 * Games Tab View Models
 *
 * Created by Pramod Selvaraj on 13/08/2021.
 */
class GamesViewModel : ViewModel() {

    private val repository = CategoryRepository()
    private lateinit var job: Job

    var mediatorLiveData: MutableLiveData<List<Category>> = MutableLiveData()

    /*Function for fetching all the Categories From The Repository & Showing To View*/
    fun fetchAllCategories(context: Context) {
        job = Coroutines.ioThenMain(
            { repository.fetchCategories(context) },
            { mediatorLiveData.postValue(it) }
        )
    }
}