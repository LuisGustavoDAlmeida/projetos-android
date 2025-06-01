package com.example.a270325

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel() {
    var contador by mutableIntStateOf(0)

    var bgColor = Color.White

    fun atualizarContador() {
        contador++
        bgColor = when {
            contador <= 5 -> Color.White
            contador <= 10 -> Color.Yellow
            contador <= 15 -> Color.Green
            else -> Color.Red
        }
    }
}