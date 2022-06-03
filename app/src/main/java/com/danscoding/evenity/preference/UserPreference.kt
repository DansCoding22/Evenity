package com.danscoding.evenity.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.danscoding.evenity.response.LoginResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

class UserPreference private constructor(private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>){

    companion object{
        @Volatile
        private var INSTANCE_USER : UserPreference? = null
        private val ACCOUNT_ERROR_KEY = booleanPreferencesKey("error")
        private val ACCOUNT_TOKEN_KEY = stringPreferencesKey("token")
        private val ACCOUNT_STATE_KEY = booleanPreferencesKey("isLogin")

        fun getInstanceUser(dataStore: DataStore<androidx.datastore.preferences.core.Preferences>): UserPreference {
            return INSTANCE_USER ?: synchronized(this) {
                val instanceUser = UserPreference(dataStore)
                INSTANCE_USER = instanceUser
                instanceUser
            }
        }
    }

    fun getToken(): Flow<LoginResponse> {
        return dataStore.data.map { preferences ->
            LoginResponse(
                preferences[ACCOUNT_ERROR_KEY]?:false,
                preferences[ACCOUNT_TOKEN_KEY]?:"",
                preferences[ACCOUNT_STATE_KEY]?:false
            )
        }
    }

    suspend fun saveToken(login : LoginResponse){
        dataStore.edit { preferences ->
            preferences[ACCOUNT_ERROR_KEY] = login.error
            preferences[ACCOUNT_TOKEN_KEY] = login.token
            preferences[ACCOUNT_STATE_KEY] = true
        }
    }
}