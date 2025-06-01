package com.example.aula_0805_e_1505

class MusicaRepositoryMockImpl : MusicaRepository {
    override suspend fun listarMusicas(token: String): List<Musica> {
        return List(10) {
            Musica(
                criadoEm = "10/10/2010",
                id = it,
                nome = "Música $it",
                albumCapa = "fake-image-$it",
                album = "Album $it",
                artista = "Artista $it"
            )
        }
    }

}