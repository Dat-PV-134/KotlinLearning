package com.example.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers() : List<User> {
        delay(10000)
        val users : List<User> = listOf(
            User(1, "Dat dep trai"),
            User(2, "Kotlin"),
            User(3, "Java"),
            User(4, "Android"),
            User(5, "Flutter")
        )
        return users
    }
}