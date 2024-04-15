package com.example.diexample.di

import com.example.diexample.MainActivity
import com.example.diexample.model.Smartphone
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        MemoryCardModule::class,
        SamsungBatteryModule::class,
    ]
)
interface SmartPhoneComponent {


    fun inject(mainActivity: MainActivity)
}

