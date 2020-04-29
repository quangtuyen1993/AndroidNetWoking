package com.example.androidnetwoking.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MessageError(
    @SerializedName("message")
    @Expose
    val message:String
)