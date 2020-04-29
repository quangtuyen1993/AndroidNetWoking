package com.example.androidnetwoking.util

import androidx.databinding.InverseMethod
import java.lang.Exception

object ConvertString {
    @InverseMethod("stringToNumber")
    @JvmStatic
    fun numberToString(number: Int): String {
        return number.toString()
    }

    @JvmStatic
    fun stringToNumber(data: String): Int {
        try{
            data?.let {
                return data.toInt()
            }
        }catch (e:Exception){
            return 0
        }


    }

}