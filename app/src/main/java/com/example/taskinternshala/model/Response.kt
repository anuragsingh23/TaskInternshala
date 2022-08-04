package com.example.taskinternshala.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class ProductsItem(
    @SerialName("image")
    val image: String?,
    @SerialName("price")
    val price: Double, // 86.44067797
    @SerialName("product_name")
    val product_name: String, // Sheet
    @SerialName("product_type")
    val product_type: String, // Product
    @SerialName("tax")
    val tax: Double // 18.0
)