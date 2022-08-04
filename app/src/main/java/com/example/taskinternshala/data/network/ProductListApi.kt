package com.example.taskinternshala.data.network

import com.example.taskinternshala.model.AddProductRequestBody
import com.example.taskinternshala.model.AddProductResponse
import com.example.taskinternshala.model.ProductsItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//se
interface ProductListApi {

    @GET("api/public/get")
    suspend fun getProductList() : List<ProductsItem>

    @POST("api/public/add")
    suspend fun addProduct(@Body addProductRequestBody: AddProductRequestBody) : AddProductResponse

}