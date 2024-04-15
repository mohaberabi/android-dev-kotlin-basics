package com.example.coroutinesdemo1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UnstructuredConcurrncy {


    suspend fun getTotalUsersCount(): Int {
        var value = 0
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            value = 50
        }
        return value
    }

    suspend fun getTotalUsersCountAsync(): Int {
        val value = 0
        val deffered = CoroutineScope(Dispatchers.IO).async {
            delay(1000)
            return@async 70
        }
        return deffered.await() + value
    }
}