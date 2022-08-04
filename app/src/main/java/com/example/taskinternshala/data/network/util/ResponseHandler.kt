package com.example.taskinternshala.data.network.util

import android.util.Log
import com.example.taskinternshala.utils.Status
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> networkRequest(dispatcher: CoroutineDispatcher = Dispatchers.IO, apiCall: suspend () -> T): Status<T> {

    return withContext(dispatcher) {
        try {
            Status.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> Status.NetworkError
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = throwable.response()
                    val response = throwable.response()?.message()
                    Log.d("TAG", "networkRequest: $code")
                    Log.d("TAG", "networkRequest: $errorResponse")
                    Log.d("TAG", "networkRequest: $response")
                    Status.Failure(code, response, errorResponse?.message())
                }
                else -> {
                    Status.Failure(null, null)
                }
            }
        }
    }
}