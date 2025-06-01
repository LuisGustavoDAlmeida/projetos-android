package com.example.navigation_200325

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation_200325.ui.theme.Navigation200325Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation200325Theme {

            }
        }
    }
}

sealed class Routes {
    data class Tela1(
        val name: String = "Tela1",
        val args: List<String>
    ) : Routes()

    data class Tela2(
        val name: String = "Tela2"
    ) : Routes()
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        startDestination = "tela1",
        navController = navController
    ) {
        composable(route = "tela1") {
            Tela1(
                navController
            )
        }
        composable(route = "tela2") {
            Tela2(
                navController

            )
        }
        composable(route = "tela3") {
            Tela3(
                navController

            )
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}

@Composable
fun Tela1(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ) {
        Text(
            color = Color.White,
            text = "ESTA É A TELA 1",
            fontSize = 40.sp
        )

        Button(onClick = {
            navController.navigate(route = "tela2")
        }) {
            Text(text = "Ir Tela 2")
        }
    }
}

@Composable
fun Tela2(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue)
    ) {
        Text(
            color = Color.White,
            text = "ESTA É A TELA 2",
            fontSize = 40.sp
        )

        Button(onClick = {
            navController.navigate(route = "tela3")
        }) {
            Text(text = "Ir Tela 3")
        }
    }
}

@Composable
fun Tela3(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
    ) {
        Text(
            color = Color.Black,
            text = "ESTA É A TELA 1",
            fontSize = 40.sp
        )
    }
}