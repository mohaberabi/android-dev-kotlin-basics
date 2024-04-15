package com.example.diexample

import android.app.Application
import com.example.diexample.di.DaggerSmartPhoneComponent
import com.example.diexample.di.MemoryCardModule
import com.example.diexample.di.SmartPhoneComponent

class MyApp : Application() {


    lateinit var smartPhoneComponent: SmartPhoneComponent
    override fun onCreate() {
        smartPhoneComponent = initDagger()
        super.onCreate()
    }


    private fun initDagger(): SmartPhoneComponent {


        val comp = DaggerSmartPhoneComponent
            .builder()
            .memoryCardModule(MemoryCardModule(100))
            .build()
        return comp
    }
}