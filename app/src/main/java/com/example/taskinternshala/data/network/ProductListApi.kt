package com.example.taskinternshala.data.network

import com.example.taskinternshala.model.AddProductRequestBody
import com.example.taskinternshala.model.AddProductResponse
import com.example.taskinternshala.model.ProductsItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//setting api interface
interface ProductListApi {

    // this is a suspend function returns list of [ProductsItem] which is the data class response form the api
    @GET("api/public/get")
    suspend fun getProductList() : List<ProductsItem>

    // this is a suspend function which takes api requestBody of post api and return Response class
    @POST("api/public/add")
    suspend fun addProduct(@Body addProductRequestBody: AddProductRequestBody) : AddProductResponse

}