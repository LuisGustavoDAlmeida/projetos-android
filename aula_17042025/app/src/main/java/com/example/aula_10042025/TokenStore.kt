package com.example.aula_10042025

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.tokenStore by preferencesDataStore(name = "tokenStore")

object TokenStore {
    private val TOKEN_KEY = stringPreferencesKey(name = "JWT_TOKEN")

    suspend fun salvarToken(context: Context, token: String) {
        context.tokenStore.edit { preferences ->
            preferences[TOKEN_KEY] = token
        }
    }

    fun obterToken(context: Context): Flow<String?> { // Flow só é coletado dentro do escopo de
        // Coroutine
        return context.tokenStore.data.map { preferences ->
            preferences[TOKEN_KEY]
        }
    }
}

