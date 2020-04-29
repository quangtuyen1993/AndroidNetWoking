package com.example.androidnetwoking.data.reponsitory

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.androidnetwoking.data.model.MessageError
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

abstract class BaseRepository {
    @Inject
    lateinit var retrofit: Retrofit
    suspend fun <T> handleResult(
        networkCall: suspend () -> Response<T>
    ):Result<T> {
        var req=networkCall.invoke();
         if (req.isSuccessful) {
             return   Result.Success<T>(req.body())
        } else {
            val converter: Converter<ResponseBody, MessageError> =
                retrofit.responseBodyConverter(
                    MessageError::class.java,
                    arrayOfNulls<Annotation>(0)
                )
            val error = converter.convert(req.errorBody())
             return    Result.Error<T>(error)
        }
    }
}