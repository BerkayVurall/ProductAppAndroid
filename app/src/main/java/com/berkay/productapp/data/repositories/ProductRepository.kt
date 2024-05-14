package com.berkay.productapp.data.repositories

import com.berkay.productapp.data.api.ApiHelper


class ProductRepository (private val apiHelper: ApiHelper) {
    suspend fun getProducts (limit : Int) = apiHelper.getProducts(limit)
    suspend fun getProductDetail (id : Int) = apiHelper.getProductDetail(id)
}