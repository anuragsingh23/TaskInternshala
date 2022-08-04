package com.example.taskinternshala.data.network

import com.example.taskinternshala.utils.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * network module provide single instance
 */
val networkModule = module {
    single { provideProductListApiService(get()) }
    single { provideRetrofit() }
}

/**
 * fun return  retrofit instance
 */

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

/**
 * f
 */
fun provideProductListApiService(retrofit: Retrofit): ProductListApi {
    return retrofit.create(ProductListApi::class.java)
}