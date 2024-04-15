package com.example.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {


    suspend fun getUsers(): List<User> {
        delay(1000)


        val users = listOf<User>(
            User(1, "Mohab"),
            User(2, "asdasd"),
            User(3, "Moasdasdhab"),
            User(4, "Mohab"),
            User(5, "Mohab"),
            User(6, "Mohab"),

            )
        return users
    }

}