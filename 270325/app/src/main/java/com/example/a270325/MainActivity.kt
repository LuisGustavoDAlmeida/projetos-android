package com.example.a270325

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a270325.ui.theme._270325Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _270325Theme {
                val viewModel = viewModel<MainViewModel>()
                App(vm = viewModel  )
            }
        }
    }
}

@Composable
fun App(vm: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = vm.bgColor)
    ) {
        Text(text = "Contador atual: ${vm.contador}")
        Button(onClick = {
            vm.atualizarContador()
        }) {
            Text(text = "Contar + 1")
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App(vm = MainViewModel())
}
