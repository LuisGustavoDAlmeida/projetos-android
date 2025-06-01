package com.example.aula_10042025

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data class login(
    val username: String,
    val password: String
)

class MainViewModel : ViewModel() {
    val musicas = mutableStateListOf<Musica>()
    var isLoading by mutableStateOf(false)
        private set

    var isAuthenticated by mutableStateOf(false)
    var userToken = MutableStateFlow("")

//    fun login(username: String, password: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            isLoading = true
//
//            try {
//                val authService = RetrofitConfig.instance.create(AuthService::class.java)
//                val response = authService.login(LoginRequest(username = "user", password = "password"))
//
//                if (response.isSuccessful) {
//                    token = response.body()
//                    isAuthenticated = true
//                    mostrarMusicas()
//                }
//            } catch (e: Exception) {
//                var errorMessage = "Erro: ${e.message}"
//            } finally {
//                isLoading = false;
//            }
//        }
//    }

    fun login(context: Context) = viewModelScope.launch {
        val authapi = RetrofitConfig.instance.create(AuthService::class.java)
        val loginRequest = LoginRequest(username = "user", password = "password")
        val response = authapi.login(loginRequest)
        if (response.isSuccessful) {
            // userToken.emit(response.body()!!.token) // Confirmação que não vai vir algo nulo
            val token = response.body()!!.token
            TokenStore.salvarToken(context, token)
        }
    }



    fun mostrarMusicas(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading = true

            val tokenMusica = token ?: throw IllegalStateException("Nenhum token disponível")
            val musicasApi = RetrofitConfig.instance.create(MusicaService::class.java)
            val response = musicasApi.listarMusicas(token = "Bearer $token")

            try {
                if (response.isSuccessful) {
                    delay(3000)
                    response.body()?.let { musicas.addAll(it) }
                } else {
                    error(
                        "Falha ao carregar músicas: ${response.errorBody()?.string()}"
                    )
                }
            } catch (e: Exception) {
                error("Error: ${e.message}")
            } finally {
                isLoading = false
            }


            if (response.isSuccessful) {
                musicas.addAll(response.body() ?: emptyList())
            }
            isLoading = false
        }
    }
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