package com.example.loginroomtest.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginroomtest.domain.model.User
import com.example.loginroomtest.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    fun insertUser(user : User) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }

    }

    fun loginUser(username: String, password: String) {
        viewModelScope.launch {
            val user = repository.getUserByUsernameAndPassword(username, password)
            _isLoggedIn.value = user != null
        }
    }

}