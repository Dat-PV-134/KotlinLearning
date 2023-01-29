package com.example.viewmodelandlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun update() {
        count.value = (count.value)?.plus(1)
    }
}