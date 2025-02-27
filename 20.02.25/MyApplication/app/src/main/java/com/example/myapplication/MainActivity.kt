package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Olá mundo, $name",
        modifier = modifier
    )
}

//@Preview(
//    widthDp = 150,
//    heightDp = 1200
//)


@Preview
@Composable
fun CustomButtonPrev() {
    CustomButton(width = 120.dp)
}


@Preview
@Composable
fun MeuTextoPreview() {
    MeuTexto()
}

@Composable
fun MeuTexto() {
    Text(
        text = "Meu Texto",
        style = MaterialTheme
            .typography
            .titleLarge.copy(
                fontSize = 16.sp
            ),
        modifier = Modifier
            .background(Color.White)
    )
}

@Composable
fun CustomButton(width: Dp = 100.dp) {
    Button(
        modifier = Modifier.width(width),
        onClick = {}) {
        if (width > 150.dp) {
            Text(
                text = "Button too large"
            )
        } else {
            Text(
                text = "Button ok"
            )
        }
        //Text(text = "Clique Aqui")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}

@Composable
fun App(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            text = "Primeiro Texto"
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Text(
            text = "Segundo Texto"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(.5f)
                .height(200.dp)
                .background(Color.Red)
        ) {
            Text(
                text = "Terceiro Texto"
            )
            Spacer(
                modifier = Modifier.width(5.dp)
            )
            Text(
                modifier = Modifier,
                text = "Quarto Texto"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FormPreview() {
    Form()
}

@Composable
fun Form(modifier: Modifier = Modifier) {
    var nome = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()) {
        TextField(
            value = nome.value,
            label = {
                Text(
                        text = "DIGITE SEU NOME"
                        )
            },
            onValueChange = {
                novoValor -> nome.value = novoValor
            }
        )
    }
}

