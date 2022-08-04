package com.example.taskinternshala.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//Response data class receive after add products on server side as Status
@Keep
@Serializable
data class AddProductResponse(
    @SerialName("message")
    val message: String, // Product added Successfully!
    @SerialName("product_details")
    val product_details: ProductDetails,
    @SerialName("product_id")
    val product_id: Int, // 2657
    @SerialName("success")
    val success: Boolean // true
)

@Keep
@Serializable
class ProductDetails