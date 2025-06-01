package com.example.a03042025_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a03042025_2.ui.theme._03042025_2Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _03042025_2Theme {
                val viewModel = viewModel<MainViewModel>()
                App(vm = viewModel<MainViewModel>())
            }
        }
    }
}

@Composable
fun App(vm: MainViewModel) {

    var contador by remember {
        mutableStateOf(0)
    }
    LaunchedEffect(true) {
        vm.atualizarContador().collect { valorEmitido ->
            contador = valorEmitido
//            println(valorEmitido) // Parâmetro coletado (poderia ser it)
        }
    }
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Valor do contador: $contador")
    }
}

@Preview
@Composable
fun AppPreview() {
    App(vm = viewModel<MainViewModel>())
}