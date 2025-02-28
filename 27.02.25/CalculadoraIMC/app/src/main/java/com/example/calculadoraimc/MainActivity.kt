package com.example.calculadoraimc

import android.graphics.Paint.Align
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CalculadoraIMCTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun Titulo() {
    Text("Calculadora IMC SPTECH")
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App();
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth().height(500.dp)) {
        Titulo();

        Row (modifier = Modifier.fillMaxWidth()){

            var nome = remember { mutableStateOf("") }

            TextField(
                modifier = Modifier.fillMaxWidth(),
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

        Spacer(modifier = Modifier.height(25.dp))


        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            var altura = remember { mutableStateOf("") }

            TextField(
                value = altura.value,
                modifier = Modifier.weight(1f),
                label = {
                    Text(
                        text = "Altura(cm)"
                    )
                },
                onValueChange = {
                        novoValor -> altura.value = novoValor
                }

            )

            var peso = remember { mutableStateOf("") }

            TextField(
                value = peso.value,
                modifier = Modifier.weight(1f),
                label = {
                    Text(
                        text = "Peso(kg)"
                    )
                },
                onValueChange = {
                        novoValor -> peso.value = novoValor
                }
            )

            var idade = remember { mutableStateOf("") }

            TextField(
                value = idade.value,
                modifier = Modifier.weight(1f),
                label = {
                    Text(
                        text = "Idade"
                    )
                },
                onValueChange = {
                        novoValor -> idade.value = novoValor
                }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically){
            CustomButton()
            }
        }
    }

//@Preview(showBackground = true)
//@Composable
//fun ButtonPreview() {
//    CustomButton()
//}

@Composable
fun CustomButton(width: Dp = 150.dp) {
    Button(
        onClick = {}) {
        Text(
            text = "Calcular"
        )
    }


}
