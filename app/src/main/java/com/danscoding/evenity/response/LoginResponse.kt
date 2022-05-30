package com.danscoding.evenity.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @SerializedName("token")
    val token : String,

    @SerializedName("isLogin")
    val isLogin : Boolean

)
