package com.example.taskinternshala.di

import com.example.taskinternshala.repository.TaskRepoImpl
import com.example.taskinternshala.utils.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { TaskRepoImpl() }
    single {}
}