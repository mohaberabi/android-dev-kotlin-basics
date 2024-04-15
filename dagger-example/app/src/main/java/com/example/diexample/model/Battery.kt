package com.example.diexample.model

import android.util.Log
import javax.inject.Inject

interface Battery {


    fun getPower()
}


class SamsungBattery @Inject constructor() : Battery {


    override fun getPower() {
        Log.i("DI", "IAM SAMSUNG BATTERY")
    }

}
