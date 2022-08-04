package com.example.taskinternshala.ui.productlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskinternshala.model.ProductsItem
import com.example.taskinternshala.repository.TaskRepo
import com.example.taskinternshala.utils.Status
import kotlinx.coroutines.launch

class ProductListViewModel constructor(private val repo: TaskRepo) : ViewModel(){

    //mutable live data object to observe and show latest
    val myResponse : MutableLiveData<Status<List<ProductsItem>>> = MutableLiveData()

    init {
        getPost()
    }

    //in this function fetching api data into mutableLiveData using Coroutine
    private  fun getPost() {
        viewModelScope.launch {
           val response = repo.getProducts()
         myResponse.value = response
        }
    }
}