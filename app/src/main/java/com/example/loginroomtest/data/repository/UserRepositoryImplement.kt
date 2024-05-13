package com.example.loginroomtest.data.repository

import com.example.loginroomtest.data.local.UserDao
import com.example.loginroomtest.domain.model.User
import com.example.loginroomtest.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImplement @Inject constructor(
    private val userDao: UserDao
) : UserRepository{

    override fun getUserByUsernameAndPassword(rfc: String, password: String): User? {
        return userDao.getUserByUsernameAndPassword(rfc = rfc, password = password)
    }

    override fun insertUser(user: User) {
        userDao.addUser(user = user)
    }

}