package com.example.loginroomtest.ui.signup

sealed interface OnSignupEvents {

    data class OnRfcChange (val rfc : String) : OnSignupEvents
    data class OnBirthDateChange (val birthDate : String) : OnSignupEvents
    data class OnNameChange (val name : String) : OnSignupEvents
    data class OnLastNameChange (val lastName : String) : OnSignupEvents
    data class OnPhoneNumberChange (val phoneNumber : String) : OnSignupEvents
    data class OnEmailChange (val email : String) : OnSignupEvents
    data class OnPasswordChange (val password : String) : OnSignupEvents
    data class OnConfirmPasswordChange (val confirmPassword : String) : OnSignupEvents

}