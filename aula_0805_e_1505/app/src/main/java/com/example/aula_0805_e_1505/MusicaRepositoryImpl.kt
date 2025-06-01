package com.example.aula_0805_e_1505

import MusicaService
import MusicaServiceMock

val musicasMock = listOf(
    Musica(
        criadoEm = "2020-08-21T00:00:00Z",
        id = 999,
        nome = "Master of Puppets",
        albumCapa = "https://example.com/covers/master_of_puppets.jpg",
        album = "Master of Puppets",
        artista = "Metallica"
    ),
    Musica(
        criadoEm = "2019-05-17T00:00:00Z",
        id = 777,
        nome = "Du Hast",
        albumCapa = "https://example.com/covers/sehnsucht.jpg",
        album = "Sehnsucht",
        artista = "Rammstein"
    ),
    Musica(
        criadoEm = "2021-10-15T00:00:00Z",
        id = 888,
        nome = "The Trooper",
        albumCapa = "https://example.com/covers/peace_sells.jpg",
        album = "Peace Sells... But Who's Buying?",
        artista = "Iron Maiden"
    )
)

class MusicaRepositoryImpl(
    private val service: MusicaService
) : MusicaRepository {
    override suspend fun listarMusicas(token: String): List<Musica> {
        val response = service.listarMusicas(token)
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            if (response.code() == 403) {
                throw Exception("Você não passará!!!!!!")
            }
            throw Exception("Deu ruim na resposta da API ...")
        }
    }

    suspend fun listarMusicas(): List<Musica> {
        val response = if (service is MusicaServiceMock) {
            service.listarMusicasMock(musicasMock.toString())
        } else {
            throw IllegalStateException("Esta operação só está disponível no mock")
        }
        return response.body() ?: emptyList()
    }
}