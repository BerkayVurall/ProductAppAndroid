package com.berkay.productapp.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.berkay.productapp.R
import com.berkay.productapp.data.model.Product
import com.berkay.productapp.utils.StringUtils.toPriceString
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter

class HorizontalProductsAdapter(private val context : Context,private val products: ArrayList<Product>) :
    SliderViewAdapter<HorizontalProductsAdapter.HorizontalProductsAdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup): HorizontalProductsAdapterViewHolder {
        val v: View =
            LayoutInflater.from(context).inflate(R.layout.slider_layout, parent, false)

        return HorizontalProductsAdapterViewHolder(v)
//
//        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.slider_layout, null)
//        return HorizontalProductsAdapterViewHolder(inflate)
    }

    var onItemClick: ((Product) -> Unit)? = null

    override fun onBindViewHolder(viewHolder: HorizontalProductsAdapterViewHolder, position: Int) {
        viewHolder.setData(products[position])
    }

    override fun getCount(): Int {
        return products.size
    }

    inner class HorizontalProductsAdapterViewHolder(itemView: View) :
        ViewHolder(itemView) {

        private var imgProduct: ImageView
        private var txtTitle : TextView
        private var txtPrice : TextView

        init {
            imgProduct = itemView.findViewById<ImageView>(R.id.imgProduct)
            txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
            txtPrice = itemView.findViewById<TextView>(R.id.txtPrice)

        }

        fun setData(
            product : Product
        ) {
            Glide.with(context)
                .load(product.image)
                .into(imgProduct);
            txtTitle.text = product.title
            txtPrice.text = product.price.toPriceString()
            itemView.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }
    }
}