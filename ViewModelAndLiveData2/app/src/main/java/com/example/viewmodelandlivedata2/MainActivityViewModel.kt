package com.example.viewmodelandlivedata2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingInput: Int) : ViewModel() {
    private val total = MutableLiveData<Int>()
    val totalData: LiveData<Int>
    get() = total

    val inputText = MutableLiveData<String>()

    init {
        total.value = startingInput
    }

    fun setTotal() {
        val input = inputText.value!!.toInt()
        total.value = (total.value)?.plus(input)
    }
}