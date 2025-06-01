package com.example.a03042025

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val emails: MutableList<String> = mutableStateListOf()

    // A ideia aqui é ser um mutable para o compose reagir ao carregamento
    var isLoading by mutableStateOf(false)
        private set // Estou dizendo que o setter disso é privado, porque ao utilizar o by ele cria um get "público"

    fun buscarEmails() {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading = true
            delay(3000)
            emails.addAll(List(100) {
                "$it E-mail"
            })
            isLoading = false
        }
    }
}