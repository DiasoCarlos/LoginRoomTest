package com.example.loginroomtest.ui.signup

data class SignupState(
    val rfc : String = "",
    val birthDate : String = "",
    val name : String = "",
    val lastName : String = "",
    val phoneNumber : String = "",
    val email : String = "",
    val password : String = "",
    val confirmPassword : String = "",
    val showDatePickerDialog : Boolean = false,
    val doValidateRFC : Boolean = false,
)
