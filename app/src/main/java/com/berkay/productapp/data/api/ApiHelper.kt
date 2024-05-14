package com.berkay.productapp.data.api

class ApiHelper (private val apiInterface: ApiInterface){
    suspend fun getProducts(limit : Int) = apiInterface.getProducts(limit)
    suspend fun getProductDetail(id : Int) = apiInterface.getProductDetail(id)
}