package com.example.loginroomtest.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.loginroomtest.core.AppConstants.Companion.USER_TABLE

@Entity(tableName = USER_TABLE)
data class User(

    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val nameUser : String,
    val username : String,
    val firstLastName : String,
    val secondLastName : String,
    val phoneNumber : String,
    val password : String

)
