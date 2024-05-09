package com.example.loginroomtest.domain.repository

import com.example.loginroomtest.domain.model.User

interface UserRepository {

    fun getUserByUsernameAndPassword (username: String, password: String) : User?

    fun insertUser(user: User)

}