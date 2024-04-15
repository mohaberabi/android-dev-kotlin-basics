package com.example.viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainViewModelParam(
    private val count: Int
) : ViewModel() {

    private var counter = 0

    init {
        counter = count
    }
}