package com.example.taskinternshala.di

import com.example.taskinternshala.repository.TaskRepo
import com.example.taskinternshala.ui.productadd.ProductAddViewModel
import com.example.taskinternshala.ui.productlist.ProductListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * koin module is used to create singleton and further inject according to needs
 * get()  function initialize the instance on compile time
 * single{}  function initialize the instance by lazy
 */

val applicationModule = module {
    single { TaskRepo(get()) }
    viewModel { ProductListViewModel(get()) }
    viewModel { ProductAddViewModel(get()) }
}
