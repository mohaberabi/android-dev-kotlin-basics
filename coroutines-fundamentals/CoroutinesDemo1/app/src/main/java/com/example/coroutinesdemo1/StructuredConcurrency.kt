package com.example.coroutinesdemo1

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StructuredConcurrency {
    var value = 0
    lateinit var deferred: Deferred<Int>
    suspend fun getTotalUsersCount(): Int {


        coroutineScope {
            launch(Dispatchers.IO) {
                delay(1000)
                value = 50
            }
            deferred = async(Dispatchers.IO) {
                delay(1000)
                return@async 70
            }
        }
        return value + deferred.await()

    }


}