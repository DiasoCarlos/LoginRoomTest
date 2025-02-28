package com.example.loginroomtest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.loginroomtest.domain.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun UserDao() : UserDao

}