package com.example.diexample.model

import javax.inject.Inject
import android.util.Log
import javax.inject.Singleton


@Singleton
class Smartphone @Inject constructor(
    private val battery: Battery,
    private val sim: Simcard,
    private val memoryCard: MemoryCard
) {


    fun makeCall() {
        Log.i("di", "CALLING VIA ${sim.getConnection()} ")
        battery.getPower()
    }
}