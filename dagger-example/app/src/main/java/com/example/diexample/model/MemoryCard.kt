package com.example.diexample.model

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton

class MemoryCard {


    fun storage() {
        Log.i("di", "4GB")
    }
}