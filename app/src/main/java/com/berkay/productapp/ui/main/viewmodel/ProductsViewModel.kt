package com.berkay.productapp.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.berkay.productapp.data.model.GetProductDetailResponse
import com.berkay.productapp.data.model.GetProductsResponse
import com.berkay.productapp.data.repositories.ProductRepository
import com.berkay.productapp.data.model.Resource
import kotlinx.coroutines.Dispatchers

class ProductsViewModel (private val productRepository: ProductRepository ) : ViewModel() {

    fun getProducts(limit : Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = GetProductsResponse(true,"",productRepository.getProducts(limit))))
        } catch (exception: Exception) {
            emit(Resource.error(data = GetProductsResponse(false,exception.message ?: "Error Occurred!",null), message = exception.message ?: "Error Occurred!"))
        }
    }
    fun getProductDetail(id : Int) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = GetProductDetailResponse(true,"",productRepository.getProductDetail(id))))
        } catch (exception: Exception) {
            emit(Resource.error(data = GetProductDetailResponse(false,exception.message ?: "Error Occurred!",null), message = exception.message ?: "Error Occurred!"))
        }
    }
}