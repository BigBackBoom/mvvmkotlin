package com.bigbackboom.mvvm_kotlin.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class CallbackBuilder<T>(
    private val onSuccess: (T) -> Unit,
    private val onError: (t: Throwable) -> Unit
){

    fun create (): Callback<T> {
        return object: Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if(response.isSuccessful && response.body() != null){
                    response.body()?.let(onSuccess)
                } else {
                    onError(Exception("Error at the server or response is null"))
                }
            }
            override fun onFailure(call: Call<T>, t: Throwable) {
                onError(t)
            }
        }
    }
}