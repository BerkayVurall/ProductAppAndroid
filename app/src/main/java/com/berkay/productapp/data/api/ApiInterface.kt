package com.berkay.productapp.data.api

import com.berkay.productapp.data.model.Product
import retrofit2.http.*

interface ApiInterface {

    @Headers("Accept: application/json")
    @GET("/products")
    suspend fun getProducts(@Query("limit") limit : Int) : ArrayList<Product>

    @Headers("Accept: application/json")
    @GET("/products/{id}")
    suspend fun getProductDetail(@Path("id") id : Int) : Product

}