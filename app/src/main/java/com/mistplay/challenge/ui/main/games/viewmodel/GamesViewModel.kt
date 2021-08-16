package com.mistplay.challenge.ui.main.games.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
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
    private lateinit var job: Job
    private val repository = CategoryRepository()

    /**
     * Lazy initialization is primarily used to improve performance,
     * avoid wasteful computation, and reduce program memory requirements.
     */
    private val _categories by lazy {
        MutableLiveData<List<Category>>()
    }

    val categories: LiveData<List<Category>> get() = _categories

    /*Function for fetching all the Categories From The Repository & Showing To View*/
    fun fetchAllCategories(context: Context) {
        job = Coroutines.ioThenMain(
            { repository.fetchCategories(context) },
            { _categories.postValue(it) }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}