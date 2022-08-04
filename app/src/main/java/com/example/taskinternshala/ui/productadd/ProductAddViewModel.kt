package com.example.taskinternshala.ui.productadd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskinternshala.model.AddProductRequestBody
import com.example.taskinternshala.repository.TaskRepoImpl
import com.example.taskinternshala.utils.Status
import com.example.taskinternshala.utils.Toast
import kotlinx.coroutines.launch

class ProductAddViewModel: ViewModel(){

    private val repo = TaskRepoImpl()

    fun addProduct(addProductRequestBody: AddProductRequestBody){
        viewModelScope.launch {
            when(val response = repo.addProduct(addProductRequestBody)){
                is Status.Failure -> {
                    Toast.showToast("Failed to Add Products ! Please try again later")
                }
                is Status.Success -> {
                    Toast.showToast("Successfully added product !")
                }
                is Status.NetworkError -> {
                    Toast.showToast("Network Error !")
                }
            }
        }
    }

}