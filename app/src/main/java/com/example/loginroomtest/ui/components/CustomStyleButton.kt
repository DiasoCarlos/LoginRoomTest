package com.example.loginroomtest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomStypeButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .background(
                Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF0047b7),
                        Color(0xFF0071cb)
                    )
                ),
                shape = RoundedCornerShape(28.dp)
            )
            .clickable(
                onClick = {
                    onClick()
                }
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            style = TextStyle(color = Color.White),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

    }

}