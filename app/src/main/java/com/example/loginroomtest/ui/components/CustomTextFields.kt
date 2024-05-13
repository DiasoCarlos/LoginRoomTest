package com.example.loginroomtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginroomtest.R

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {

    CustomTextField(
        modifier = modifier,
        label = label,
        value = value,
        placeholder = placeholder,
        isPassword = true
    ) {
        onValueChange(it)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {

    var hidePassword by remember {
        mutableStateOf(true)
    }

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(
                text = placeholder,
                color = Color.Gray
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            focusedLabelColor = Color.Black,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        ),
        trailingIcon = {
            if (isPassword) {

                Icon(
                    painter = painterResource(id = if (hidePassword) R.drawable.ic_visibility_on else R.drawable.ic_visibility_off),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        hidePassword = !hidePassword
                    }
                )

            }
        },
        visualTransformation = if (isPassword && hidePassword) PasswordVisualTransformation() else VisualTransformation.None,
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDisabledTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = label)
        },
        readOnly = true,
        enabled = false,
        colors = TextFieldDefaults
            .outlinedTextFieldColors(
                containerColor = Color.Transparent,
                disabledBorderColor = Color.Black,
                disabledLabelColor = Color.Black,
                disabledTextColor = Color.Black,
            )
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldDatePicker(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onClick: () -> Unit,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .clickable {
                onClick()
            },
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = label)
        },
        readOnly = true,
        enabled = false,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.Transparent,
            disabledBorderColor = Color.Black,
            disabledLabelColor = Color.Black,
            disabledTextColor = Color.Black,

            )
    )

}

@Preview(showSystemUi = true)
@Composable
private fun PreviewButtons() {

    Column {
        CustomTextField(
            label = "Normal",
            value = "Normal",
            placeholder = "Normal",
            onValueChange = {}
        )
        CustomTextFieldDatePicker(
            label = "Date",
            value = "Date",
            onClick = { /*TODO*/ }) {

        }
        CustomDisabledTextField(
            label = "Disabled",
            value = "Disabled"
        ) {

        }
        PasswordTextField(
            label = "Password",
            value = "Pepe",
            placeholder = "***",
        ) {

        }
    }

}