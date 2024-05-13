package com.example.loginroomtest.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.loginroomtest.R
import com.example.loginroomtest.ui.components.CustomStypeButton
import com.example.loginroomtest.ui.components.CustomTextField
import com.example.loginroomtest.ui.components.PasswordTextField
import com.example.loginroomtest.ui.theme.FontBlue
import com.example.loginroomtest.ui.theme.PrimaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNewRegisterClick : () -> Unit
) {

    val state = viewModel.state

    var logged by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondo_blanco_premier),
                contentScale = ContentScale.Crop
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier
                    .padding(20.dp)
                    .height(60.dp),
                painter = painterResource(id = R.drawable.logo_nombre),
                contentDescription = "Logo Premier",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(30.dp))

            if (logged) {

                Text(
                    text = "HOLA, ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = FontBlue,
                    modifier = Modifier
                )

            } else {

                CustomTextField(
                    value = state.username,
                    onValueChange = {
                        viewModel.onEvent(
                            LoginEvents.UsernameChange(it)
                        )
                    },
                    label = "Usuario",
                    placeholder = "Usuario"
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            PasswordTextField(
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(
                        LoginEvents.PasswordChange(it)
                    )
                },
                label = "Ingresa la contrasena",
                placeholder = "******"
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))

                CustomStypeButton(
                    text = "INICIAR SESION",
                    modifier = Modifier
                        .height(60.dp)
                        .width(180.dp)
                ) {
                    logged = !logged
                }

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))

                CustomStypeButton(
                    text = "NUEVO REGISTRO",
                    modifier = Modifier
                        .height(60.dp)
                        .width(180.dp)
                ) {
                    onNewRegisterClick()
                }

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Recuperar la contrasena",
                color = PrimaryText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                painter = painterResource(id = R.mipmap.logo_diaso),
                contentDescription = "Logo Diaso",
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.weight(1f))

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