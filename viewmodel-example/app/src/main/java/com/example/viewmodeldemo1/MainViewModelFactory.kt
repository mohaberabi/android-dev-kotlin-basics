package com.example.viewmodeldemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(
    private val count: Int
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModelParam::class.java)) {
            return MainViewModelParam(count) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}