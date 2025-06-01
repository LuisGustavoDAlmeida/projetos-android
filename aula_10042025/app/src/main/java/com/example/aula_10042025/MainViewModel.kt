package com.example.aula_10042025

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val musicas = mutableStateListOf<Musica>()
    var isLoading by mutableStateOf(false)
        private set

    fun mostrarMusicas() {
        val musicasApi = RetrofitConfig.instance.create(MusicaService::class.java)

        viewModelScope.launch(Dispatchers.IO) {
            isLoading = true
            delay(3000)
            val response =
                musicasApi.listarMusicas(token = "TOKEN AQUI") // Não é só a lista de músicas, mas a resposta da API

            if (response.isSuccessful) {
                musicas.addAll(response.body() ?: emptyList())
            }
//            musicas.addAll(
//                listOf(
//                    Musica(
//                        "1987",
//                        0,
//                        "testeNome",
//                        "testeCapa",
//                        "testeAlbum",
//                        "testeArtista"
//                    ),
//                    Musica(
//                        "1987",
//                        1,
//                        "testeNome",
//                        "testeCapa",
//                        "testeAlbum",
//                        "testeArtista"
//                    ),
//                    Musica(
//                        "1987",
//                        3,
//                        "testeNome",
//                        "testeCapa",
//                        "testeAlbum",
//                        "testeArtista"
//                    )
//                )
//            val responseMocado = List(30) {
//                Musica(
//                    id = it,
//                    criadoEm = "$it Criado em",
//                    nome = "$it nome",
//                    albumCapa = "https://loremflickr.com/cache/resized/640/480/abstract",
//                    album = "$it album",
//                    artista = "$it artista"
//                )
//            }
//            musicas.addAll(responseMocado)
            isLoading = false
        }
    }
}