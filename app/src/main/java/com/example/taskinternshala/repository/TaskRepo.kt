package com.example.taskinternshala.repository

import com.example.taskinternshala.data.network.ProductListApi
import com.example.taskinternshala.data.network.util.networkRequest
import com.example.taskinternshala.model.AddProductRequestBody
import com.example.taskinternshala.model.AddProductResponse
import com.example.taskinternshala.model.ProductsItem
import com.example.taskinternshala.utils.Status

//repo class is response for center of data ..
//all the data is being passed from here to viewModel
class TaskRepo constructor(private val productListApi: ProductListApi)  {

    suspend fun getProducts() : Status<List<ProductsItem>> {
        return networkRequest { productListApi.getProductList() }
    }

    suspend fun addProduct(addProductRequestBody: AddProductRequestBody): Status<AddProductResponse> {
        return networkRequest { productListApi.addProduct(addProductRequestBody = addProductRequestBody) }
    }
}