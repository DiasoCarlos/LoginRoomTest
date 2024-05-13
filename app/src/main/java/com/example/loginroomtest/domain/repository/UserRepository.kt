package com.example.loginroomtest.domain.repository

import com.example.loginroomtest.domain.model.User

interface UserRepository {

    fun getUserByUsernameAndPassword (rfc: String, password: String) : User?

    fun insertUser(user: User)

}