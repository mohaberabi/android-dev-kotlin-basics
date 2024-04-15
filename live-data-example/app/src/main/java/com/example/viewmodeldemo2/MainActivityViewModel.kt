package com.example.viewmodeldemo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {

    private val _total = MutableLiveData<Int>(0)


    init {
        _total.value = startingTotal
    }

    val total: LiveData<Int>
        get() = _total


    fun setTotal(input: Int) {
        _total.value = _total.value?.plus(input)
    }
}