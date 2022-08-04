package com.example.taskinternshala.ui.productlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskinternshala.model.ProductsItem
import com.example.taskinternshala.repository.TaskRepoImpl
import com.example.taskinternshala.utils.Status
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel(){

   private val repo = TaskRepoImpl()

    val myResponse : MutableLiveData<Status<List<ProductsItem>>> = MutableLiveData()

    init {
        getPost()
    }

    //in this function fetching api data into mutableLiveData using CoroutineScope
    private  fun getPost() {
        viewModelScope.launch {
           val response = repo.getProducts()
         myResponse.value = response
        }
    }
}