package com.example.viewmodeldemo1

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count = 0
    fun getCount(): Int = count


    fun getUpdatedCount(): Int {
        return ++count
    }

}