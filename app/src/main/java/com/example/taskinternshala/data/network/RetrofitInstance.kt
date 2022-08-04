package com.example.taskinternshala.data.network

import com.example.taskinternshala.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : ProductListApi by lazy {
        retrofit.create(ProductListApi::class.java)
    }
}