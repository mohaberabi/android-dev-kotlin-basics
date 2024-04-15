package com.example.diexample.model

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Simcard @Inject constructor(
    private val serviceProvider: ServiceProvider
) {


    fun getConnection() {
        Log.i("di", "${serviceProvider.toString()}")
    }
}