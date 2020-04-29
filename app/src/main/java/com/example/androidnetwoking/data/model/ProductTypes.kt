package com.example.androidnetwoking.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductTypes(
    @SerializedName("_id")
    var _id: String?,
    @SerializedName("name")
    var _name: String?,
    @SerializedName("description")
    var _description: String?
): Parcelable

