package com.example.loginroomtest.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var state by mutableStateOf(LoginState())
        private set

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> = _isLoggedIn

    fun onEvent(event : LoginEvents){

        when(event){
            is LoginEvents.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
            is LoginEvents.UsernameChange -> {
                state = state.copy(
                    username = event.username
                )
            }
        }

    }

    fun loginUser(rfc: String, password: String) {
        viewModelScope.launch {
            val user = repository.getUserByUsernameAndPassword(rfc, password)
            _isLoggedIn.value = user != null
        }
    }

}