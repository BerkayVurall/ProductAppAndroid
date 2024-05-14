package com.berkay.productapp.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.berkay.productapp.data.api.ApiHelper
import com.berkay.productapp.data.repositories.ProductRepository
import com.berkay.productapp.ui.main.viewmodel.ProductsViewModel
import java.lang.IllegalArgumentException


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(ProductRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}