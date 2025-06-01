package com.example.aula_10042025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aula_10042025.ui.theme.Aula_10042025Theme
import java.io.BufferedReader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aula_10042025Theme {
                val viewModel = viewModel<MainViewModel>()
                App(vm = viewModel)
            }
        }
    }
}

@Composable
fun App(vm: MainViewModel) {
    val context = LocalContext.current
    LaunchedEffect(true) {
        TokenStore.obterToken(context).collect { token -> // Fica de olho até chegar algo
            token?.let {
                vm.mostrarMusicas(it)
            }

//            if (token != null) { MOSTRAR O DE CIMA
//                vm.mostrarMusicas(token)
//            }
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        if (vm.isLoading) {
            LoadingBar()
        } else {
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(vm.musicas) { musica ->
                    MusicaCard(musica)
                }
            }
        }


//    LazyColumn(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//    ) {
//        if (vm.isLoading) {
//            item {
//                LoadingBar()
//            }
//        } else {
//
//        }
//    }
    }
}


@Preview
@Composable
fun AppPreview() {
    App(vm = viewModel())
}