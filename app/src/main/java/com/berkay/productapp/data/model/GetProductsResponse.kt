package com.berkay.productapp.data.model

data class GetProductsResponse(
    var success : Boolean,
    var message : String,
    var data : ArrayList<Product>?
)
