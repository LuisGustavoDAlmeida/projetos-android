package com.example.aula_10042025

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

object RetrofitConfig {

    private const val BASE_URL =
        "https://lbdsph32nqwu4qytpmlua55c3a0gptkz.lambda-url.us-east-1.on.aws"


    val instance =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Transforma no nosso objeto
            .build()

//    val x = instance.create(MusicaService::class.java) // Interface não há instância, mas passamos código fonte para classe
}

interface MusicaService {
    @GET("/musicas")
    suspend fun listarMusicas(
        @Header("Authorization") token: String
    ): Response<List<Musica>>
}

interface AuthService {
    @POST("/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<String>
}

data class LoginResponse(val token: String)

data class LoginRequest(
    val username: String,
    val password: String
)