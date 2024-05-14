package com.berkay.productapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berkay.productapp.R
import com.berkay.productapp.data.model.Product
import com.berkay.productapp.databinding.ActivityProductDetailBinding
import com.berkay.productapp.utils.StringUtils.toPriceString
import com.bumptech.glide.Glide
import com.google.gson.Gson

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductDetailBinding
    private lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getProduct()
    }

    private fun getProduct(){
        val productString = intent.getStringExtra("product")
        product = Gson().fromJson(productString,Product::class.java)
        fetchProduct()
    }

    private fun fetchProduct(){
        binding.txtTitle.text = product.title
        binding.txtDescription.text = product.description
        binding.txtPrice.text = product.price.toPriceString()
        Glide.with(this)
            .load(product.image)
            .into(binding.imgProduct);
        binding.rating.rating = product.rating.rate.toFloat()
    }
}