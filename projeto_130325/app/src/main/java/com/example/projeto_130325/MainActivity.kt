package com.example.projeto_130325

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projeto_130325.ui.theme.Projeto_130325Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Projeto_130325Theme {
                AppCorreto()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppPreview() {
    AppCorreto()
}

@Composable
fun AppCorreto(modifier: Modifier = Modifier) {
    val alunos = List(50) {
        "Aluno $it"
    }

//    LazyColumn(modifier = Modifier.padding(16.dp)) {
//
//        item {
//            Text(
//                modifier = Modifier.background(color = Color.Green),
//                fontSize = 40.sp,
//                text = "HEADER"
//            )
//        }
//
//
//        itemsIndexed(alunos) { index, aluno ->
//            val cardColor = when {
//                index % 2 == 0 -> Color.Red
//                else -> Color.Blue
//            }
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .padding(bottom = 10.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = cardColor
//                )
//            ) {
//                Text(text = aluno)
//            }
//        }
//    }

//    LazyRow {
//        item {
//            Text(
//                modifier = Modifier.background(color = Color.Green),
//                fontSize = 40.sp,
//                text = "HEADER"
//            )
//        }
//
//
//        itemsIndexed(alunos) { index, aluno ->
//            val cardColor = when {
//                index % 2 == 0 -> Color.Red
//                else -> Color.Blue
//            }
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .padding(bottom = 10.dp),
//                colors = CardDefaults.cardColors(
//                    containerColor = cardColor
//                )
//            ) {
//                Text(text = aluno)
//            }
//        }
//    }

    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        itemsIndexed(alunos) { index, aluno ->
            val cardColor = when {
                index % 2 == 0 -> Color.Red
                else -> Color.Blue
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = cardColor
                )
            ) {
                Text(text = aluno)
            }
        }
    }
}


@Composable
fun App(modifier: Modifier = Modifier) {
    val alunos = List(20) {
        "Aluno $it"
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        alunos.forEachIndexed { index, aluno ->
            val cardColor = when {
                index % 2 == 0 -> Color.Red
                else -> Color.Blue
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = cardColor
                )
            ) {
                Text(text = aluno)
            }
        }
    }
}