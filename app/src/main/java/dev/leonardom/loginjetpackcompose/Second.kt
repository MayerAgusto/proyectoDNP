package dev.leonardom.loginjetpackcompose

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.sp

@Composable
fun SecondView() {

    Surface(
    ) {
        Text("Hello World", fontSize = 30.sp, color = Color.Black)
    }
}