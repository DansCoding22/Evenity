package com.danscoding.evenity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.danscoding.evenity.preference.UserPreference
import com.danscoding.evenity.response.LoginResponse
import kotlinx.coroutines.launch

class MainViewModel(private val preference : UserPreference): ViewModel() {

    fun tokenSave(login: LoginResponse){
        viewModelScope.launch {
            preference.saveToken(LoginResponse(login.error, login.token, login.isLogin))
        }
    }

    fun tokenGet(): LiveData<LoginResponse>{
        return preference.getToken().asLiveData()
    }

}