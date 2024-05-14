package com.berkay.productapp.data.model

data class Product(
    var id : Int,
    var title : String,
    var price : Double,
    var description : String,
    var category : String,
    var image : String,
    var rating : Rating
)
