package com.danscoding.evenity.api

import com.danscoding.evenity.model.LoginModel
import com.danscoding.evenity.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    fun loginUser(@Header("Content-type") header : String, @Body login : LoginModel): Call<LoginResponse>

}