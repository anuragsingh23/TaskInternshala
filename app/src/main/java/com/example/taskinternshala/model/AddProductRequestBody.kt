package com.example.taskinternshala.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data  class AddProductRequestBody(

    @SerialName("product_name")
    val product_name : String,
    @SerialName(" product_type")
    val product_type : String,
    @SerialName("price")
    val price : String,
    @SerialName("tax")
    val tax : String,
)