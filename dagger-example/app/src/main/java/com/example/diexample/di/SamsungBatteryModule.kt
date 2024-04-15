package com.example.diexample.di

import com.example.diexample.model.Battery
import com.example.diexample.model.SamsungBattery
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SamsungBatteryModule {


    @Binds
    abstract fun provideSamsungBattery(samsungBattery: SamsungBattery): Battery
}