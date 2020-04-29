package com.example.androidnetwoking.data.reponsitory

import com.example.androidnetwoking.data.model.MessageError


sealed class Result<T> {
    class Success<T>(var data: T?) : Result<T>()
    class Error<T>(var message: MessageError?) : Result<T>()
    class Loading<Nothing>() : Result<Nothing>()
}