package com.mistplay.challenge.ui.bonus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BonusViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This Is Bonus Screen"
    }
    val text: LiveData<String> = _text
}