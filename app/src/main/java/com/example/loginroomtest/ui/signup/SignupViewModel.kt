package com.example.loginroomtest.ui.signup

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginroomtest.data.remote.AnticipoNominaApis
import com.example.loginroomtest.domain.model.User
import com.example.loginroomtest.domain.repository.UserRepository
import com.example.loginroomtest.domain.valida_rfc.model.ValidaRFCRequest
import com.example.loginroomtest.domain.valida_rfc.repository.AnticipoNominaApisRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val repository: UserRepository,
    private val anticipoNominaRepository: AnticipoNominaApisRepository
) :ViewModel() {

    var state by mutableStateOf(SignupState())
        private set

    fun onEvent(event: OnSignupEvents){

        when(event){
            is OnSignupEvents.OnBirthDateChange -> {
                state = state.copy(
                    birthDate = event.birthDate
                )
            }
            is OnSignupEvents.OnConfirmPasswordChange -> {
                state = state.copy(
                    confirmPassword = event.confirmPassword
                )
            }
            is OnSignupEvents.OnEmailChange -> {
                state = state.copy(
                    email = event.email
                )
            }
            is OnSignupEvents.OnLastNameChange -> {
                state = state.copy(
                    lastName = event.lastName
                )
            }
            is OnSignupEvents.OnNameChange -> {
                state = state.copy(
                    name = event.name
                )
            }
            is OnSignupEvents.OnPasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }
            is OnSignupEvents.OnPhoneNumberChange -> {
                state = state.copy(
                    phoneNumber = event.phoneNumber
                )
            }
            is OnSignupEvents.OnRfcChange -> {
                state = state.copy(
                    rfc = event.rfc
                )
            }
        }

    }

    fun insertUser(user : User) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(user)
        }

    }

    fun validateRFC(context: Context){

        viewModelScope.launch(Dispatchers.IO){

            try {
                val response = anticipoNominaRepository.validaRFC(ValidaRFCRequest(
                    Fecha = "2002-03-26",
                    RFC = "AAAD020326410"
                ))

                state = state.copy(
                    name = response.body()?.Nombre.toString() ?: "Fallos",
                    lastName = "${response.body()!!.APaterno} ${response.body()!!.APaterno}"
                )

                Log.e("APIS", "Exito, mensaje :" + "${response.body()!!.Mensaje}")
            }catch (e:Exception){
                Log.e("APIS", e.message.toString())
                //Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }

        }

    }

}