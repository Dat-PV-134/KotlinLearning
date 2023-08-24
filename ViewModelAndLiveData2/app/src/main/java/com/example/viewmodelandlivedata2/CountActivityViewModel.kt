package com.example.viewmodelandlivedata2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountActivityViewModel : ViewModel() {
    private val count = MutableLiveData<Int>()
    val countData: LiveData<Int>
    get() = count

    init {
        count.value = 0
    }

    fun setCount() {
        count.value = (count.value)?.plus(1)
    }
}