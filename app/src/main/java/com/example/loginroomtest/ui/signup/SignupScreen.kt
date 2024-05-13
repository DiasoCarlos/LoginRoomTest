package com.example.loginroomtest.ui.signup

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.loginroomtest.R
import com.example.loginroomtest.domain.model.User
import com.example.loginroomtest.ui.components.CustomDisabledTextField
import com.example.loginroomtest.ui.components.CustomStypeButton
import com.example.loginroomtest.ui.components.CustomTextField
import com.example.loginroomtest.ui.components.CustomTextFieldDatePicker
import com.example.loginroomtest.ui.components.DatePickerWithDialog
import com.example.loginroomtest.ui.components.PasswordTextField
import com.example.loginroomtest.ui.theme.PrimaryTextColor

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun SignupScreen(
    viewModel: SignupViewModel = hiltViewModel()
) {

    var clienteProspecto by remember {
        mutableStateOf(true)
    }

    val context = LocalContext.current

    val state = viewModel.state

    if (state.doValidateRFC) {
        if (state.rfc.isNotEmpty() && state.birthDate.isNotEmpty()) {
            viewModel.validateRFC(rfc = state.rfc, fechaNac = state.birthDate)
            viewModel.onEvent(
                OnSignupEvents.DoValidateRFC
            )
        } else {
            Toast.makeText(context, "Llena tu RFC y Fecha de nacimiento", Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondo_blanco_premier),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.BottomCenter
    ) {

        DatePickerWithDialog(
            showDialog = state.showDatePickerDialog,
            onDismissClick = {
                viewModel.onEvent(
                    OnSignupEvents.ShowDatePicker
                )
            },
            onBirthDateChange = {
                viewModel.onEvent(
                    OnSignupEvents.OnBirthDateChange(it)
                )
            },
            onValidateRfc = {
                viewModel.onEvent(
                    OnSignupEvents.DoValidateRFC
                )
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "Crea tu cuenta",
                color = PrimaryTextColor,
                fontSize = 34.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Ingresa tus datos para comenzar",
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            AnimatedContent(
                targetState = !clienteProspecto,
                label = ""
            ) {

                Column(
                    modifier = Modifier
                        .padding(top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    when (it) {

                        true -> {

                            CustomTextField(
                                modifier = Modifier,
                                value = state.phoneNumber,
                                onValueChange = {
                                    viewModel.onEvent(
                                        OnSignupEvents.OnPhoneNumberChange(it)
                                    )
                                },
                                label = "Telefono",
                                placeholder = "P. ej 5511223344"
                            )

                            CustomTextField(
                                modifier = Modifier,
                                value = state.email,
                                onValueChange = {
                                    viewModel.onEvent(
                                        OnSignupEvents.OnEmailChange(it)
                                    )
                                },
                                label = "Correo Electronico",
                                placeholder = "P. ej correo@dominio.com"
                            )

                            PasswordTextField(
                                modifier = Modifier,
                                value = state.password,
                                onValueChange = {
                                    viewModel.onEvent(
                                        OnSignupEvents.OnPasswordChange(it)
                                    )
                                },
                                label = "Contrasena",
                                placeholder = "******"
                            )

                            PasswordTextField(
                                modifier = Modifier,
                                value = state.confirmPassword,
                                onValueChange = {
                                    viewModel.onEvent(
                                        OnSignupEvents.OnConfirmPasswordChange(it)
                                    )
                                },
                                label = "Confirmar Contrasena",
                                placeholder = "******"
                            )

                            CustomStypeButton(
                                text = "LISTO",
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(45.dp)
                            ) {
                                clienteProspecto = !clienteProspecto
                            }


                        }

                        false -> {

                            CustomTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                value = state.rfc,
                                onValueChange = {
                                    viewModel.onEvent(
                                        OnSignupEvents.OnRfcChange(it)
                                    )
                                },
                                label = "RFC",
                                placeholder = "P. ej AAAA09091000JSA"
                            )

                            CustomTextFieldDatePicker(
                                value = state.birthDate,
                                onClick = {
                                    viewModel.onEvent(
                                        OnSignupEvents.ShowDatePicker
                                    )
                                },
                                onValueChange = {
                                },
                                label = "Fecha de Nacimiento"
                            )

                            CustomDisabledTextField(
                                value = state.name,
                                onValueChange = {
                                    viewModel.onEvent(
                                        OnSignupEvents.OnNameChange(it)
                                    )
                                },
                                label = "Nombre(s)"
                            )

                            CustomDisabledTextField(
                                value = state.lastName,
                                onValueChange = {
                                    viewModel.onEvent(
                                        OnSignupEvents.OnLastNameChange(it)
                                    )
                                },
                                label = "Apellido(s)"
                            )

                            CustomStypeButton(
                                text = "CONTINUAR",
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(45.dp)
                            ) {
                                clienteProspecto = !clienteProspecto
                            }

                        }

                    }

                }

            }

        }

        Column {

            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color.Gray
                    )
                    .clickable {

                    },
                text = "Ya tengo Cuenta",
                textAlign = TextAlign.Center,
                color = Color.White
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                text = "Contacto",
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                text = "Legales",
                textAlign = TextAlign.Center
            )

        }

    }

}