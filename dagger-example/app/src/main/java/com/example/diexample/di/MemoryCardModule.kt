package com.example.diexample.di

import android.util.Log
import com.example.diexample.model.MemoryCard
import dagger.Module
import dagger.Provides


@Module
class MemoryCardModule(val memorySize: Int) {


    @Provides
    fun provideMemoryCard(): MemoryCard {

        Log.i("di", "Size of memeory is ${memorySize}")
        return MemoryCard()
    }
}