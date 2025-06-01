package com.example.aula_0805_e_1505

interface MusicaRepository {
    suspend fun listarMusicas(token: String): List<Musica>
}