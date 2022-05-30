package com.danscoding.evenity.response

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @field:SerializedName("error")
    val error : Boolean,

)
