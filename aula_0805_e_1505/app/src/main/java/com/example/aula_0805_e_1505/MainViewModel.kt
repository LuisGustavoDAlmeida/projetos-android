package com.example.aula_0805_e_1505

import LoginRequest
import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(
    private val musicaRepository : MusicaRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    val musicas = mutableStateListOf<Musica>()
    var isLoading by mutableStateOf(false)
        private set

    fun loadMusicas(token : String) {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading = true
            val listaMusicas = musicaRepository.listarMusicas(token)
            musicas.addAll(listaMusicas)
            isLoading = false
        }
    }

    fun login(context: Context) = viewModelScope.launch {
        val loginRequest = LoginRequest(
            username = "user",
            password = "password"
        )
        val loginResponse = authRepository.login(loginRequest)
        TokenStore.salvarToken(context, loginResponse!!.token)

    }
}