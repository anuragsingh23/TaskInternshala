package com.example.taskinternshala.repository

import com.example.taskinternshala.data.network.RetrofitInstance
import com.example.taskinternshala.data.network.util.networkRequest
import com.example.taskinternshala.model.AddProductRequestBody
import com.example.taskinternshala.model.AddProductResponse
import com.example.taskinternshala.model.ProductsItem
import com.example.taskinternshala.utils.Status

class TaskRepoImpl  {

    suspend fun getProducts() : Status<List<ProductsItem>> {
        return networkRequest { RetrofitInstance.api.getProductList() }
    }

    suspend fun addProduct(addProductRequestBody: AddProductRequestBody): Status<AddProductResponse> {
        return networkRequest { RetrofitInstance.api.addProduct(addProductRequestBody = addProductRequestBody) }
    }
}