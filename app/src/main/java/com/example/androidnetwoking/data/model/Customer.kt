package com.example.androidnetwoking.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("_id")
    @Expose
    var id: String,
    @SerializedName("username")
    @Expose
    var username: String,
    @Expose
    @SerializedName("password")
    var password: String
)