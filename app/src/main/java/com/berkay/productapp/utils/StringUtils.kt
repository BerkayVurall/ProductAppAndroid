package com.berkay.productapp.utils


object StringUtils {
    fun Double.toPriceString() : String{
        return String.format("%.2f", this) + " TL"
    }
}