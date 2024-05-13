package com.example.loginroomtest.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import java.time.Instant
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerWithDialog(
    modifier: Modifier = Modifier,
    showDialog : Boolean = false,
    onDismissClick : () -> Unit,
    onBirthDateChange : (String) -> Unit,
    onValidateRfc : () -> Unit
) {

    val state = rememberDatePickerState()

    if (showDialog) {

        DatePickerDialog(
            modifier = modifier,
            onDismissRequest = {
                onDismissClick()
            },
            confirmButton = {
                TextButton(onClick = {
                    val date = state.selectedDateMillis
                    date?.let {
                        val localDate = Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()
                        val day :String = if (localDate.dayOfMonth < 10) "0${localDate.dayOfMonth.toString()}" else localDate.dayOfMonth.toString()
                        val month :String = if (localDate.monthValue < 10) "0${localDate.monthValue.toString()}" else localDate.monthValue.toString()
                        onBirthDateChange("${localDate.year}/$month/$day")
                    }
                    onDismissClick()
                    onValidateRfc()
                }) {
                    Text(text = "OK")
                }
            }
        ) {

            DatePicker(state = state)
            
        }

    }

}