package com.mistplay.challenge.ui.main.games.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GamesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This Is Games Screen"
    }
    val text: LiveData<String> = _text
}