package com.example.aula_0805_e_1505

import AuthService
import LoginRequest
import LoginResponse


class AuthRepository(private val service: AuthService) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse? {
        val response = service.login(loginRequest)

        if (response.isSuccessful) {
            return response.body()
        } else {
            throw Exception("Deu ruim no login rapaz ...")
        }
    }
}
