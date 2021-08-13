package com.mistplay.challenge.ui.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This Is Shops Screen"
    }
    val text: LiveData<String> = _text
}