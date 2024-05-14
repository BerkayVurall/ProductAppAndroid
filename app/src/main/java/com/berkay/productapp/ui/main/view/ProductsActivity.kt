package com.berkay.productapp.ui.main.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.berkay.productapp.data.api.ApiHelper
import com.berkay.productapp.data.api.ApiInterface
import com.berkay.productapp.data.api.RetrofitClient
import com.berkay.productapp.data.model.Product
import com.berkay.productapp.databinding.ActivityProductsBinding
import com.berkay.productapp.ui.base.ViewModelFactory
import com.berkay.productapp.ui.main.adapters.HorizontalProductsAdapter
import com.berkay.productapp.ui.main.adapters.VerticalProductsAdapter
import com.berkay.productapp.ui.main.viewmodel.ProductsViewModel
import com.berkay.productapp.data.model.Status
import com.google.gson.Gson
import com.smarteist.autoimageslider.SliderView
import com.utarit.bayindirhastanesimobil.constants.dialogs.LoadingDialog
import com.utarit.bayindirhastanesimobil.constants.dialogs.MessageDialog


class ProductsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityProductsBinding
    private lateinit var viewModel : ProductsViewModel
    private lateinit var loading : Dialog
    private var horizontalProducts : ArrayList<Product> = arrayListOf()
    private var verticalProducts : ArrayList<Product> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setLoadingDialog()
        getVerticalProducts()
        getHorizontalProducts()
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitClient.getClient().create(ApiInterface::class.java)))
        )[ProductsViewModel::class.java]
    }

    private fun setLoadingDialog(){
        loading = LoadingDialog(this@ProductsActivity,false).getLoading()
    }

    private fun getHorizontalProducts(){
        viewModel.getProducts(5).observe(this){
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        loading.dismiss()
                        if(it.data!!.success){
                            horizontalProducts = it.data.data!!
                            setHorizontalProducts()
                        }else{
                            MessageDialog(this@ProductsActivity,false,"Hata!",it.data.message).getDialog().show()
                        }
                    }
                    Status.ERROR -> {
                        loading.dismiss()
                        MessageDialog(this@ProductsActivity,false,"Hata!",it.message.toString()).getDialog().show()
                    }
                    Status.LOADING -> {
                        loading.show()
                    }
                }
            }
        }
    }

    private fun setHorizontalProducts(){
        val adapter = HorizontalProductsAdapter(this, horizontalProducts)
        binding.sliderProducts.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        adapter.onItemClick = { product ->
            getProductDetail(product.id)
        }
        binding.sliderProducts.setSliderAdapter(adapter)

    }

    private fun getVerticalProducts(){
        viewModel.getProducts(0).observe(this){
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        loading.dismiss()
                        if(it.data!!.success){
                            verticalProducts = it.data.data!!
                            setVerticalProducts()
                        }else{
                            MessageDialog(this@ProductsActivity,false,"Hata!",it.data.message).getDialog().show()
                        }
                    }
                    Status.ERROR -> {
                        loading.dismiss()
                        MessageDialog(this@ProductsActivity,false,"Hata!",it.message.toString()).getDialog().show()
                    }
                    Status.LOADING -> {
                        loading.show()
                    }
                }
            }
        }
    }

    private fun setVerticalProducts(){
        val adapter = VerticalProductsAdapter(verticalProducts,this)
        adapter.onItemClick = { product ->
            getProductDetail(product.id)
        }
        val manager = GridLayoutManager(this, 2)
        binding.rcyVerticalProducts.setHasFixedSize(false)
        binding.rcyVerticalProducts.layoutManager = manager
        binding.rcyVerticalProducts.adapter = adapter
    }

    private fun getProductDetail(productId : Int){
        viewModel.getProductDetail(productId).observe(this){
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        loading.dismiss()
                        if(it.data!!.success){
                            goDetailPage(it.data.data!!)
                        }else{
                            MessageDialog(this@ProductsActivity,false,"Hata!",it.data.message).getDialog().show()
                        }
                    }
                    Status.ERROR -> {
                        loading.dismiss()
                        MessageDialog(this@ProductsActivity,false,"Hata!",it.message.toString()).getDialog().show()
                    }
                    Status.LOADING -> {
                        loading.show()
                    }
                }
            }
        }
    }

    private fun goDetailPage(product : Product){
        val intent = Intent(this,ProductDetailActivity::class.java)
        intent.putExtra("product", Gson().toJson(product))
        startActivity(intent)
    }

}