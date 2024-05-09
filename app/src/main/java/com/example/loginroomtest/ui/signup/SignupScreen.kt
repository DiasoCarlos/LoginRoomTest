package com.example.loginroomtest.ui.signup

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.loginroomtest.ui.components.CustomStypeButton
import com.example.loginroomtest.ui.theme.PrimaryTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(
    viewModel: SignupViewModel = hiltViewModel()
) {

    var clienteProspecto by remember {
        mutableStateOf(true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

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

            if (clienteProspecto) {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "RFC")
                    },
                    placeholder = {
                        Text(
                            text = "P. ej AAAA09091000JSA",
                            color = Color.Gray
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .clickable {

                        },
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Fecha de Nacimiento")
                    },
                    readOnly = true,
                    enabled = false,
                    colors = TextFieldDefaults.textFieldColors(
                        disabledIndicatorColor = Color.Black,
                        containerColor = Color.Transparent,
                        disabledTextColor = Color.Black,
                        disabledLabelColor = Color.Black
                    )
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .clickable {

                        },
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Nombre(s)")
                    },
                    readOnly = true,
                    enabled = false
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .clickable {

                        },
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Apellido(s)")
                    },
                    readOnly = true,
                    enabled = false
                )

                CustomStypeButton(
                    text = "CONTINUAR",
                    modifier = Modifier
                        .width(120.dp)
                        .height(65.dp)
                        .padding(top = 20.dp)
                ) {
                    clienteProspecto = !clienteProspecto
                }

            } else {

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Telefono")
                    },
                    placeholder = {
                        Text(
                            text = "P. ej 5511223344",
                            color = Color.Gray
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Correo Electronico")
                    },
                    placeholder = {
                        Text(
                            text = "P. ej correo@dominio.com",
                            color = Color.Gray
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Contrasena")
                    },
                    placeholder = {
                        Text(
                            text = "******",
                            color = Color.Gray
                        )
                    }
                )

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp),
                    value = "",
                    onValueChange = {},
                    label = {
                        Text(text = "Confirmar Contrasena")
                    },
                    placeholder = {
                        Text(
                            text = "******",
                            color = Color.Gray
                        )
                    }
                )

                CustomStypeButton(
                    text = "LISTO",
                    modifier = Modifier
                        .width(120.dp)
                        .height(65.dp)
                        .padding(top = 20.dp)
                ) {
                    clienteProspecto = !clienteProspecto
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