package com.example.androidnetwoking.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(


    @SerializedName("_id")
    var _id: String,
    @SerializedName("_idProductType")
    var _idTypeProduct: String,
    @SerializedName("nameProduct")
    var nameProduct: String,
    @SerializedName("urlImgProduct")
    var urlImg: String,
    @SerializedName("price")
    var price: Int
) : Parcelable{
    constructor(_idTypeProduct: String,nameProduct: String,urlImg: String,price: Int) : this(
      "0", _idTypeProduct,nameProduct,urlImg,price
    )
}