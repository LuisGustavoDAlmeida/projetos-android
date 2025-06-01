package com.example.a03042025_2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    fun atualizarContador(): Flow<Int> = flow {
        withContext(Dispatchers.Default) {

        }
        for (i in 10 downTo 0) {
            emit(i)
            delay(1000)
        }
    }
}