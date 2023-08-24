package com.example.twowaydemo1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val name = MutableLiveData<String>()
    val nameData: MutableLiveData<String>
    get() = name

    init {
        name.value = "rekoJ"
    }
}