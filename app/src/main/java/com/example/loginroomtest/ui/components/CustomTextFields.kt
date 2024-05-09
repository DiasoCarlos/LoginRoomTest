package com.example.loginroomtest.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
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
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.Transparent,
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            focusedLabelColor = Color.Black,
            textColor = Color.Black
        )
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
            .padding(top = 20.dp),
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
            .padding(top = 20.dp)
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
            value = "Disabled") {
            
        }
    }

}