package com.berkay.productapp.data.model

data class GetProductDetailResponse(
    var success : Boolean,
    var message : String,
    var data : Product?
)
