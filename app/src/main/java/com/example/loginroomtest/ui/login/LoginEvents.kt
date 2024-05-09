package com.example.loginroomtest.ui.login

sealed interface LoginEvents {

    data class UsernameChange(val username : String) : LoginEvents

    data class PasswordChange(val password : String) : LoginEvents

}