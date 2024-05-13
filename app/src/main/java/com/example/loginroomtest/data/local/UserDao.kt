package com.example.loginroomtest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.loginroomtest.core.AppConstants.Companion.USER_TABLE
import com.example.loginroomtest.domain.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM $USER_TABLE WHERE rfc = :rfc AND password = :password")
    fun getUserByUsernameAndPassword(rfc : String, password : String) : User?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addUser(user: User)

}